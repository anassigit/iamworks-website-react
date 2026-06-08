import { Link } from 'react-router-dom';
import { formatCurrency } from '../api/client';

export default function ProductCard({ product, priority = false }) {
  return (
    <article className="product-card">
      <Link to={`/products/${product.slug}`} className="product-image-wrap">
        <img src={product.image} alt={product.name} loading={priority ? 'eager' : 'lazy'} />
      </Link>
      <div className="product-copy">
        <p className="product-series">{product.series}</p>
        <Link to={`/products/${product.slug}`} className="product-name">
          {product.name}
        </Link>
        <div className="product-meta">
          <span>{formatCurrency(product.price, product.currency)}</span>
          <span>{product.category}</span>
        </div>
      </div>
    </article>
  );
}
