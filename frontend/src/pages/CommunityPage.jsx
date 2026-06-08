import { useMemo, useRef, useState } from 'react';
import { apiClient } from '../api/client';
import LoadingState from '../components/LoadingState';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

export default function CommunityPage() {
  const { data, loading } = useApi(apiClient.getCommunity, []);
  const [activeTab, setActiveTab] = useState('');
  const scopeRef = useRef(null);

  useGsapReveal(scopeRef, [data, activeTab]);

  const visiblePosts = useMemo(() => {
    if (!data) {
      return [];
    }

    const currentTab = activeTab || data.tabs[0];
    return data.posts.filter((post) => post.tag === currentTab);
  }, [data, activeTab]);

  if (loading && !data) {
    return <LoadingState label="Loading community feed..." />;
  }

  const currentTab = activeTab || data.tabs[0];

  return (
    <div ref={scopeRef} className="container page-stack">
      <section className="community-shell" data-animate="fade-up">
        <div className="section-heading">
          <div>
            <p className="section-eyebrow">Built by riders</p>
            <h1>{data.title}</h1>
            <p className="page-summary">{data.subtitle}</p>
          </div>
        </div>

        <div className="tab-row" data-animate="fade-up">
          {data.tabs.map((tab) => (
            <button
              type="button"
              key={tab}
              className={currentTab === tab ? 'tab-button active' : 'tab-button'}
              onClick={() => setActiveTab(tab)}
            >
              {tab}
            </button>
          ))}
        </div>

        <div className="community-grid" data-animate="stagger">
          {visiblePosts.map((post) => (
            <article key={post.title} className="community-card">
              <img src={post.image} alt={post.title} />
              <div className="community-copy">
                <p className="section-eyebrow">{post.tag}</p>
                <h3>{post.title}</h3>
              </div>
            </article>
          ))}
        </div>

        <button type="button" className="ghost-button centered" data-animate="fade-up">
          Load More
        </button>
      </section>
    </div>
  );
}
