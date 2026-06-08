import { useRef } from 'react';
import { Link, useLocation, useParams } from 'react-router-dom';
import { useGsapReveal } from '../hooks/useGsapReveal';

const pageContent = {
  '/iam-garage': {
    eyebrow: 'IAM Garage',
    title: 'Garage stories are next in line.',
    description: 'Use this placeholder route for featured bikes, builder stories, and workshop showcases until the dedicated section is implemented.',
    primaryLabel: 'Browse Shop',
    primaryHref: '/shop',
    secondaryLabel: 'Visit Community',
    secondaryHref: '/community'
  },
  '/journal': {
    eyebrow: 'Journal',
    title: 'Editorial content can plug in here.',
    description: 'The route is wired so navigation stays intact while blog posts, riding guides, and collection stories are added later.',
    primaryLabel: 'Explore Collections',
    primaryHref: '/collections',
    secondaryLabel: 'Read About the Brand',
    secondaryHref: '/about'
  },
  '/contact': {
    eyebrow: 'Contact',
    title: 'Contact details can live on this page.',
    description: 'Keep this route for WhatsApp, email, and stockist information so the template remains navigable end to end.',
    primaryLabel: 'Follow Instagram',
    primaryHref: 'https://www.instagram.com/iamworks.id',
    secondaryLabel: 'Back to Home',
    secondaryHref: '/'
  }
};

const supportContent = {
  faq: {
    eyebrow: 'Support',
    title: 'FAQ content is ready for this route.',
    description: 'Add answers for sizing, preorder windows, and stock updates here when support copy is available.'
  },
  shipping: {
    eyebrow: 'Support',
    title: 'Shipping and return details belong here.',
    description: 'This placeholder keeps the footer contract working until the full policy content is added.'
  },
  'size-chart': {
    eyebrow: 'Support',
    title: 'Size chart content can plug in here.',
    description: 'Use this route for garment measurements and fit guidance without breaking existing footer links.'
  }
};

function getPageCopy(pathname, topic) {
  if (pathname.startsWith('/support/')) {
    const supportPage = supportContent[topic] || supportContent.faq;

    return {
      ...supportPage,
      primaryLabel: 'Browse Shop',
      primaryHref: '/shop',
      secondaryLabel: 'Read About the Brand',
      secondaryHref: '/about'
    };
  }

  return pageContent[pathname] || pageContent['/contact'];
}

function ActionLink({ href, children, variant = 'ghost' }) {
  const className = variant === 'primary' ? 'primary-button' : 'ghost-button';

  if (href.startsWith('http')) {
    return (
      <a className={className} href={href} target="_blank" rel="noreferrer">
        {children}
      </a>
    );
  }

  return (
    <Link className={className} to={href}>
      {children}
    </Link>
  );
}

export default function PlaceholderPage() {
  const location = useLocation();
  const { topic } = useParams();
  const content = getPageCopy(location.pathname, topic);
  const scopeRef = useRef(null);

  useGsapReveal(scopeRef, [location.pathname, topic]);

  return (
    <div ref={scopeRef} className="container page-stack">
      <section className="section-block placeholder-card" data-animate="hero-panel">
        <div data-animate="hero-copy">
          <p className="section-eyebrow">{content.eyebrow}</p>
          <h1>{content.title}</h1>
        </div>
        <p className="page-summary">{content.description}</p>
        <div className="placeholder-actions">
          <ActionLink href={content.primaryHref} variant="primary">
            {content.primaryLabel}
          </ActionLink>
          <ActionLink href={content.secondaryHref}>{content.secondaryLabel}</ActionLink>
        </div>
      </section>
    </div>
  );
}
