import { Link } from 'react-router-dom';

function FooterLink({ link }) {
  if (link.href === '#newsletter') {
    return (
      <button
        type="button"
        className="footer-link"
        onClick={() => document.getElementById('newsletter')?.scrollIntoView({ behavior: 'smooth', block: 'start' })}
      >
        {link.label}
      </button>
    );
  }

  if (link.href.startsWith('/')) {
    return (
      <Link className="footer-link" to={link.href}>
        {link.label}
      </Link>
    );
  }

  return (
    <a className="footer-link" href={link.href}>
      {link.label}
    </a>
  );
}

export default function SiteFooter({ footer, brand }) {
  return (
    <footer className="site-footer" id="newsletter">
      <div className="container footer-grid">
        <div className="footer-brand">
          <div className="logo footer-logo">
            <span>{brand?.name?.split(' ')[0] || 'I\'AM'}</span>
            <span>{brand?.name?.split(' ')[1] || 'Works'}</span>
          </div>
          <p>{footer?.description}</p>
          <div className="social-row">
            {(footer?.socials || []).map((social) => (
              <a key={social.label} href={social.href} target="_blank" rel="noreferrer">
                {social.label}
              </a>
            ))}
          </div>
        </div>

        {(footer?.columns || []).map((column) => (
          <div key={column.title}>
            <p className="footer-heading">{column.title}</p>
            <div className="footer-links">
              {column.links.map((link) => (
                <FooterLink key={link.label} link={link} />
              ))}
            </div>
          </div>
        ))}

        <div className="newsletter-card">
          <p className="footer-heading">Newsletter</p>
          <p>{footer?.newsletterText}</p>
          <form className="newsletter-form" onSubmit={(event) => event.preventDefault()}>
            <input type="email" placeholder="Your email" aria-label="Email address" />
            <button type="submit">Subscribe</button>
          </form>
        </div>
      </div>

      <div className="container footer-bottom">
        <p>{footer?.copyright}</p>
        <p className="script-mark">Stay Wild & Free</p>
      </div>
    </footer>
  );
}
