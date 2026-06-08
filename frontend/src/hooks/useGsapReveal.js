import { useLayoutEffect } from 'react';
import gsap from 'gsap';
import { ScrollTrigger } from 'gsap/ScrollTrigger';
import { usePrefersReducedMotion } from './usePrefersReducedMotion';

gsap.registerPlugin(ScrollTrigger);

export function useGsapReveal(scopeRef, deps = []) {
  const prefersReducedMotion = usePrefersReducedMotion();

  useLayoutEffect(() => {
    if (!scopeRef.current) {
      return undefined;
    }

    const ctx = gsap.context(() => {
      if (prefersReducedMotion) {
        gsap.set(
          [
            '[data-animate="hero-panel"]',
            '[data-animate="hero-copy"] > *',
            '[data-animate="fade-up"]',
            '[data-animate="stagger"] > *'
          ],
          { clearProps: 'all', autoAlpha: 1, y: 0, scale: 1 }
        );
        return;
      }

      gsap.utils.toArray('[data-animate="hero-panel"]').forEach((panel) => {
        gsap.fromTo(
          panel,
          { autoAlpha: 0, scale: 0.985 },
          { autoAlpha: 1, scale: 1, duration: 0.9, ease: 'power2.out' }
        );
      });

      gsap.utils.toArray('[data-animate="hero-copy"]').forEach((copy) => {
        gsap.fromTo(
          copy.children,
          { autoAlpha: 0, y: 24 },
          { autoAlpha: 1, y: 0, duration: 0.72, stagger: 0.08, ease: 'power3.out', delay: 0.16 }
        );
      });

      gsap.utils.toArray('[data-animate="fade-up"]').forEach((element) => {
        gsap.fromTo(
          element,
          { autoAlpha: 0, y: 28 },
          {
            autoAlpha: 1,
            y: 0,
            duration: 0.68,
            ease: 'power2.out',
            scrollTrigger: {
              trigger: element,
              start: 'top 86%',
              once: true
            }
          }
        );
      });

      gsap.utils.toArray('[data-animate="stagger"]').forEach((container) => {
        const items = Array.from(container.children);

        if (!items.length) {
          return;
        }

        gsap.fromTo(
          items,
          { autoAlpha: 0, y: 24 },
          {
            autoAlpha: 1,
            y: 0,
            duration: 0.62,
            stagger: 0.1,
            ease: 'power2.out',
            scrollTrigger: {
              trigger: container,
              start: 'top 84%',
              once: true
            }
          }
        );
      });

      ScrollTrigger.refresh();
    }, scopeRef);

    return () => ctx.revert();
  }, [scopeRef, prefersReducedMotion, ...deps]);
}
