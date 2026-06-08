import { useRef } from 'react';
import { apiClient } from '../api/client';
import LoadingState from '../components/LoadingState';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

export default function AboutPage() {
  const { data, loading } = useApi(apiClient.getAbout, []);
  const scopeRef = useRef(null);

  useGsapReveal(scopeRef, [data]);

  if (loading && !data) {
    return <LoadingState label="Loading brand story..." />;
  }

  return (
    <div ref={scopeRef} className="container page-stack">
      <section className="about-hero" data-animate="stagger">
        <div className="about-copy">
          <h1>
            {data.title} <span>{data.accentTitle}</span> Company
          </h1>
          <p>{data.description}</p>
          <p className="script-mark">{data.scriptText}</p>
          <button type="button" className="ghost-button">
            {data.ctaLabel}
          </button>
        </div>
        <div className="about-image-card">
          <img src={data.heroImage} alt={`${data.accentTitle} crew`} />
        </div>
      </section>
    </div>
  );
}
