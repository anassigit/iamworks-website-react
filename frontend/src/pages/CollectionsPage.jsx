import { useRef } from 'react';
import { Link } from 'react-router-dom';
import { apiClient } from '../api/client';
import LoadingState from '../components/LoadingState';
import ProductCard from '../components/ProductCard';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

export default function CollectionsPage() {
  const { data, loading } = useApi(apiClient.getCollections, []);
  const scopeRef = useRef(null);

  useGsapReveal(scopeRef, [data]);

  if (loading && !data) {
    return <LoadingState label="Loading collection campaign..." />;
  }

  return (
    <div ref={scopeRef} className="container page-stack">
      <section
        className="collection-hero"
        style={{ '--hero-image': `url(${data.hero.image})` }}
        data-animate="hero-panel"
      >
        <div className="collection-copy" data-animate="hero-copy">
          <p className="section-eyebrow">{data.hero.name}</p>
          <h1>{data.hero.title}</h1>
          <p>{data.hero.description}</p>
          <Link className="ghost-button" to="/shop">
            {data.hero.ctaLabel}
          </Link>
        </div>
      </section>

      <section className="section-block" data-animate="fade-up">
        <div className="section-heading">
          <div>
            <p className="section-eyebrow">Collection Line-Up</p>
            <h2>Dark graphics. Heavyweight foundations.</h2>
          </div>
        </div>
        <div className="product-grid four-up" data-animate="stagger">
          {data.products.map((product) => (
            <ProductCard key={product.slug} product={product} />
          ))}
        </div>
      </section>
    </div>
  );
}
