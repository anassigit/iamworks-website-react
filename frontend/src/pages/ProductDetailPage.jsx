import { useMemo, useRef, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { apiClient, formatCurrency } from '../api/client';
import LoadingState from '../components/LoadingState';
import ProductCard from '../components/ProductCard';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

const accordionSections = [
  { key: 'description', label: 'Description' },
  { key: 'shipping', label: 'Shipping & Returns' },
  { key: 'care', label: 'Material & Care' },
  { key: 'reviews', label: 'Reviews' }
];

export default function ProductDetailPage() {
  const { slug } = useParams();
  const { data, loading } = useApi(() => apiClient.getProductBySlug(slug), [slug]);
  const scopeRef = useRef(null);
  const [activeImage, setActiveImage] = useState(0);
  const [selectedSize, setSelectedSize] = useState('');
  const [quantity, setQuantity] = useState(1);
  const [openSection, setOpenSection] = useState('description');

  useGsapReveal(scopeRef, [data, slug]);

  const descriptionMap = useMemo(
    () => ({
      description: data?.description,
      shipping: 'Fast dispatch from the workshop. Easy 30-day returns on unworn items with original tags.',
      care: 'Cold wash, inside out. Do not tumble dry. Store flat to preserve print texture and heavyweight structure.',
      reviews: `${data?.reviewCount} verified rider reviews with an average rating of ${data?.rating}/5.`
    }),
    [data]
  );

  if (loading && !data) {
    return <LoadingState label="Loading product detail..." />;
  }

  return (
    <div ref={scopeRef} className="container page-stack">
      <div className="detail-layout" data-animate="stagger">
        <div className="detail-gallery">
          <div className="thumbnail-rail">
            {data.gallery.map((image, index) => (
              <button
                type="button"
                key={`${image}-${index}`}
                className={activeImage === index ? 'thumb-button active' : 'thumb-button'}
                onClick={() => setActiveImage(index)}
              >
                <img src={image} alt={`${data.name} view ${index + 1}`} />
              </button>
            ))}
          </div>
          <div className="hero-image-card">
            <img src={data.gallery[activeImage]} alt={data.name} />
          </div>
        </div>

        <section className="detail-copy">
          <p className="product-series">{data.series}</p>
          <h1>{data.name}</h1>
          <p className="detail-price">{formatCurrency(data.price, data.currency)}</p>
          <p className="rating-line">
            {'★'.repeat(Math.round(data.rating))} <span>({data.reviewCount} reviews)</span>
          </p>
          <p className="detail-description">{data.description}</p>

          <ul className="highlight-list">
            {data.highlights.map((highlight) => (
              <li key={highlight}>{highlight}</li>
            ))}
          </ul>

          <div className="size-selector">
            <div className="size-row">
              <p className="filter-title">Size</p>
              <Link to="/about" className="text-action">
                Size Chart
              </Link>
            </div>
            <div className="chip-list">
              {data.sizes.map((size) => (
                <button
                  type="button"
                  key={size}
                  className={selectedSize === size ? 'size-chip active' : 'size-chip'}
                  onClick={() => setSelectedSize(size)}
                >
                  {size}
                </button>
              ))}
            </div>
          </div>

          <div className="purchase-row">
            <div className="quantity-stepper">
              <button type="button" onClick={() => setQuantity((value) => Math.max(1, value - 1))}>
                −
              </button>
              <span>{quantity}</span>
              <button type="button" onClick={() => setQuantity((value) => value + 1)}>
                +
              </button>
            </div>
            <button type="button" className="primary-button wide">
              Add to Cart
            </button>
          </div>

          <button type="button" className="ghost-button wide">
            Add to Wishlist
          </button>
        </section>
      </div>

      <div className="accordion-list" data-animate="fade-up">
        {accordionSections.map((section) => (
          <div key={section.key} className="accordion-item">
            <button type="button" className="accordion-toggle" onClick={() => setOpenSection(section.key)}>
              <span>{section.label}</span>
              <span>{openSection === section.key ? '−' : '+'}</span>
            </button>
            {openSection === section.key ? <p className="accordion-copy">{descriptionMap[section.key]}</p> : null}
          </div>
        ))}
      </div>

      <div className="feature-strip compact">
        <div className="feature-item">
          <span className="feature-icon">◈</span>
          <div>
            <p>Premium Quality</p>
            <small>Built to last</small>
          </div>
        </div>
        <div className="feature-item">
          <span className="feature-icon">◈</span>
          <div>
            <p>Easy Returns</p>
            <small>30 days return</small>
          </div>
        </div>
        <div className="feature-item">
          <span className="feature-icon">◈</span>
          <div>
            <p>Secure Payment</p>
            <small>100% protected</small>
          </div>
        </div>
      </div>

      <section className="section-block" data-animate="fade-up">
        <div className="section-heading">
          <div>
            <p className="section-eyebrow">Related Picks</p>
            <h2>Complete the drop</h2>
          </div>
        </div>
        <div className="product-grid four-up" data-animate="stagger">
          {data.related.map((product) => (
            <ProductCard key={product.slug} product={product} />
          ))}
        </div>
      </section>
    </div>
  );
}
