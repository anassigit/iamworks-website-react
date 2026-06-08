import { useRef } from 'react';
import { Link } from 'react-router-dom';
import { apiClient } from '../api/client';
import FeatureStrip from '../components/FeatureStrip';
import LoadingState from '../components/LoadingState';
import ProductCard from '../components/ProductCard';
import SectionShell from '../components/SectionShell';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

export default function HomePage() {
  const { data, loading } = useApi(apiClient.getHome, []);
  const scopeRef = useRef(null);

  useGsapReveal(scopeRef, [data]);

  if (loading && !data) {
    return <LoadingState label="Loading home drop..." />;
  }

  return (
    <div ref={scopeRef} className="container page-stack">
      <section
        className="hero-panel"
        style={{ '--hero-image': `url(${data.hero.image})` }}
        data-animate="hero-panel"
      >
        <div className="hero-copy" data-animate="hero-copy">
          <p className="section-eyebrow">{data.hero.eyebrow}</p>
          <h1>{data.hero.title}</h1>
          <p className="script-mark hero-script">{data.hero.scriptText}</p>
          <p className="hero-description">{data.hero.description}</p>
          <Link className="primary-button" to={data.hero.ctaHref}>
            {data.hero.ctaLabel}
          </Link>
        </div>
      </section>

      <FeatureStrip features={data.hero.features} />

      <SectionShell
        title="New Collection"
        action={
          <Link className="text-action" to="/shop">
            View All
          </Link>
        }
      >
        <div className="product-grid four-up" data-animate="stagger">
          {data.newCollection.map((product, index) => (
            <ProductCard key={product.slug} product={product} priority={index === 0} />
          ))}
        </div>
      </SectionShell>

      <div className="highlight-grid" data-animate="stagger">
        <section className="promo-card" style={{ '--panel-image': `url(${data.newCollection[1]?.image || data.hero.image})` }}>
          <div className="promo-card__content">
            <p className="section-eyebrow">Limited Series</p>
            <h3>Collections made to feel like imported premium drops.</h3>
            <p>Explore Bloodthorn, Neuro, Dominus Noctis, and more with a gallery-first layout inspired by the mockup direction.</p>
            <Link className="ghost-button" to="/collections">
              Explore Collection
            </Link>
          </div>
        </section>
        <section className="promo-card muted" style={{ '--panel-image': `url(${data.hero.image})` }}>
          <div className="promo-card__content">
            <p className="section-eyebrow">Community</p>
            <h3>From rider stories to event coverage and bike features.</h3>
            <p>Showcase the broader I&apos;AM Works culture beyond product shelves.</p>
            <Link className="ghost-button" to="/community">
              Join the Crew
            </Link>
          </div>
        </section>
      </div>
    </div>
  );
}
