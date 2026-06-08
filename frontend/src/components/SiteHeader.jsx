import { useEffect, useLayoutEffect, useRef, useState } from 'react';
import gsap from 'gsap';
import { Link, NavLink, useLocation } from 'react-router-dom';
import { usePrefersReducedMotion } from '../hooks/usePrefersReducedMotion';

function logoText(name) {
  return (name || 'I\'AM Works').split(' ');
}

export default function SiteHeader({ brand, navigation = [] }) {
  const [lineOne = 'I\'AM', lineTwo = 'Works'] = logoText(brand?.name);
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const panelRef = useRef(null);
  const location = useLocation();
  const prefersReducedMotion = usePrefersReducedMotion();

  useEffect(() => {
    setIsMenuOpen(false);
  }, [location.pathname]);

  useEffect(() => {
    function handleResize() {
      if (window.innerWidth >= 960) {
        setIsMenuOpen(false);
      }
    }

    window.addEventListener('resize', handleResize);

    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  useEffect(() => {
    document.body.classList.toggle('menu-open', isMenuOpen);

    return () => {
      document.body.classList.remove('menu-open');
    };
  }, [isMenuOpen]);

  useLayoutEffect(() => {
    if (!panelRef.current) {
      return undefined;
    }

    const isMobile = window.matchMedia('(max-width: 959px)').matches;

    if (!isMobile) {
      gsap.set(panelRef.current, { clearProps: 'all' });
      gsap.set(panelRef.current.querySelectorAll('.nav-link, .menu-intro, .nav-actions--menu'), { clearProps: 'all' });
      return undefined;
    }

    if (!isMenuOpen || prefersReducedMotion) {
      return undefined;
    }

    const ctx = gsap.context(() => {
      gsap.fromTo(
        panelRef.current,
        { autoAlpha: 0, y: -18 },
        { autoAlpha: 1, y: 0, duration: 0.28, ease: 'power2.out' }
      );
      gsap.fromTo(
        panelRef.current.querySelectorAll('.menu-intro, .nav-link, .nav-actions--menu > *'),
        { autoAlpha: 0, y: 16 },
        { autoAlpha: 1, y: 0, duration: 0.32, stagger: 0.06, ease: 'power2.out', delay: 0.08 }
      );
    }, panelRef);

    return () => ctx.revert();
  }, [isMenuOpen, prefersReducedMotion]);

  return (
    <header className={`site-header ${isMenuOpen ? 'menu-open' : ''}`.trim()}>
      <div className="container nav-bar">
        <Link className="logo" to="/">
          <span>{lineOne}</span>
          <span>{lineTwo}</span>
        </Link>

        <button
          type="button"
          className={`nav-toggle ${isMenuOpen ? 'active' : ''}`.trim()}
          aria-label={isMenuOpen ? 'Close navigation menu' : 'Open navigation menu'}
          aria-expanded={isMenuOpen}
          aria-controls="site-navigation"
          onClick={() => setIsMenuOpen((current) => !current)}
        >
          <span />
          <span />
          <span />
        </button>

        <nav className="main-nav" id="site-navigation" aria-label="Primary">
          <div ref={panelRef} className="main-nav__panel">
            <div className="menu-intro">
              <p className="section-eyebrow">Navigation</p>
              <p>{brand?.tagline || 'Stay Wild & Free'}</p>
            </div>

            <div className="main-nav__links">
              {navigation.map((item) => (
                <NavLink
                  key={item.href}
                  to={item.href}
                  className={({ isActive }) => (isActive ? 'nav-link active' : 'nav-link')}
                >
                  {item.label}
                </NavLink>
              ))}
            </div>

            <div className="nav-actions nav-actions--menu" aria-label="Quick actions">
              <button type="button" className="icon-button" aria-label="Search">
                ⌕
              </button>
              <button type="button" className="icon-button" aria-label="Account">
                ⊙
              </button>
              <button type="button" className="icon-button" aria-label="Cart">
                👜
              </button>
            </div>
          </div>
        </nav>

        <div className="nav-actions nav-actions--desktop" aria-label="Quick actions">
          <button type="button" className="icon-button" aria-label="Search">
            ⌕
          </button>
          <button type="button" className="icon-button" aria-label="Account">
            ⊙
          </button>
          <button type="button" className="icon-button" aria-label="Cart">
            👜
          </button>
        </div>
      </div>
    </header>
  );
}
