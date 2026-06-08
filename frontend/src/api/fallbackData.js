const images = {
  hero:
    'https://images.unsplash.com/photo-1517841905240-472988babdf9?auto=format&fit=crop&w=1400&q=80',
  about:
    'https://images.unsplash.com/photo-1523398002811-999ca8dec234?auto=format&fit=crop&w=1200&q=80',
  collection:
    'https://images.unsplash.com/photo-1517260911205-8af5c55c58b5?auto=format&fit=crop&w=1400&q=80',
  community:
    'https://images.unsplash.com/photo-1515777315835-281b94c9589f?auto=format&fit=crop&w=900&q=80',
  neuroHoodie:
    'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?auto=format&fit=crop&w=900&q=80',
  bloodthornHoodie:
    'https://images.unsplash.com/photo-1503342394128-c104d54dba01?auto=format&fit=crop&w=900&q=80',
  clownPsycho:
    'https://images.unsplash.com/photo-1504593811423-6dd665756598?auto=format&fit=crop&w=900&q=80',
  dominus:
    'https://images.unsplash.com/photo-1527719327859-c6ce80353573?auto=format&fit=crop&w=900&q=80',
  blackVoltage:
    'https://images.unsplash.com/photo-1507679799987-c73779587ccf?auto=format&fit=crop&w=900&q=80',
  chromePhantom:
    'https://images.unsplash.com/photo-1483985988355-763728e1935b?auto=format&fit=crop&w=900&q=80',
  gloves:
    'https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=900&q=80',
  waistBag:
    'https://images.unsplash.com/photo-1548036328-c9fa89d128fa?auto=format&fit=crop&w=900&q=80',
  gallery1:
    'https://images.unsplash.com/photo-1523398002811-999ca8dec234?auto=format&fit=crop&w=900&q=80',
  gallery2:
    'https://images.unsplash.com/photo-1503342394128-c104d54dba01?auto=format&fit=crop&w=900&q=80',
  gallery3:
    'https://images.unsplash.com/photo-1504593811423-6dd665756598?auto=format&fit=crop&w=900&q=80',
  post1:
    'https://images.unsplash.com/photo-1519764622345-23439dd774f7?auto=format&fit=crop&w=800&q=80',
  post2:
    'https://images.unsplash.com/photo-1517167685281-3ca8a806b9f2?auto=format&fit=crop&w=800&q=80',
  post3:
    'https://images.unsplash.com/photo-1520975916090-3105956dac38?auto=format&fit=crop&w=800&q=80',
  post4:
    'https://images.unsplash.com/photo-1494976388531-d1058494cdd8?auto=format&fit=crop&w=800&q=80',
  post5:
    'https://images.unsplash.com/photo-1521334884684-d80222895322?auto=format&fit=crop&w=800&q=80',
  post6:
    'https://images.unsplash.com/photo-1485965120184-e220f721d03e?auto=format&fit=crop&w=800&q=80'
};

const productCatalog = [
  {
    slug: 'neuro-hoodie',
    name: 'Neuro Hoodie',
    price: 689000,
    currency: 'IDR',
    image: images.neuroHoodie,
    category: 'Hoodie',
    series: 'Neuro'
  },
  {
    slug: 'bloodthorn-hoodie',
    name: 'Bloodthorn Hoodie',
    price: 849000,
    currency: 'IDR',
    image: images.bloodthornHoodie,
    category: 'Hoodie',
    series: 'Bloodthorn'
  },
  {
    slug: 'clown-psycho-tshirt',
    name: 'Clown Psycho T-Shirt',
    price: 329000,
    currency: 'IDR',
    image: images.clownPsycho,
    category: 'T-Shirt',
    series: 'Clown Psycho'
  },
  {
    slug: 'dominus-noctis-hoodie',
    name: 'Dominus Noctis Hoodie',
    price: 698000,
    currency: 'IDR',
    image: images.dominus,
    category: 'Hoodie',
    series: 'Dominus Noctis'
  },
  {
    slug: 'black-voltage-hoodie',
    name: 'Black Voltage Hoodie',
    price: 699000,
    currency: 'IDR',
    image: images.blackVoltage,
    category: 'Hoodie',
    series: 'Black Voltage'
  },
  {
    slug: 'chrome-phantom-tee',
    name: 'Chrome Phantom T-Shirt',
    price: 329000,
    currency: 'IDR',
    image: images.chromePhantom,
    category: 'T-Shirt',
    series: 'Chrome Phantom'
  },
  {
    slug: 'iam-gloves-black',
    name: 'I\'AM Gloves - Black',
    price: 399000,
    currency: 'IDR',
    image: images.gloves,
    category: 'Accessories',
    series: 'Riding Accessories'
  },
  {
    slug: 'iam-waist-bag',
    name: 'I\'AM Waist Bag',
    price: 198000,
    currency: 'IDR',
    image: images.waistBag,
    category: 'Accessories',
    series: 'Riding Accessories'
  }
];

const productDetails = {
  'neuro-hoodie': {
    slug: 'neuro-hoodie',
    name: 'Neuro Hoodie',
    price: 689000,
    currency: 'IDR',
    rating: 4.9,
    reviewCount: 35,
    description:
      'Heavyweight hoodie built for the late-night road. Premium fleece body, bold front puff print, and a sharp back graphic inspired by custom garage circuitry.',
    highlights: [
      '450 GSM cotton fleece',
      'Puff print front emblem',
      'Plastisol back print',
      'Oversize fit for layered riding',
      'Ribbed cuff and hem finish'
    ],
    sizes: ['S', 'M', 'L', 'XL', 'XXL'],
    gallery: [images.gallery1, images.neuroHoodie, images.gallery2, images.gallery3],
    series: 'Neuro',
    category: 'Hoodie',
    related: productCatalog.filter((item) => item.slug !== 'neuro-hoodie').slice(0, 4)
  }
};

const footer = {
  description: 'Riding apparel and gear built for the wild ones.',
  socials: [
    { label: 'Instagram', href: 'https://instagram.com' },
    { label: 'TikTok', href: 'https://tiktok.com' },
    { label: 'YouTube', href: 'https://youtube.com' }
  ],
  columns: [
    {
      title: 'Shop',
      links: [
        { label: 'All Products', href: '/shop' },
        { label: 'Hoodie', href: '/shop' },
        { label: 'Accessories', href: '/shop' }
      ]
    },
    {
      title: 'Collections',
      links: [
        { label: 'Bloodthorn', href: '/collections' },
        { label: 'Neuro', href: '/collections' },
        { label: 'Clown Psycho', href: '/collections' }
      ]
    },
    {
      title: 'Support',
      links: [
        { label: 'FAQ', href: '/about' },
        { label: 'Shipping & Returns', href: '/about' },
        { label: 'Contact Us', href: '#newsletter' }
      ]
    }
  ],
  newsletterText: 'Join our newsletter and get 10% off your first order.',
  copyright: '© 2024 I\'AM Works Company. All Rights Reserved.'
};

export const fallbackData = {
  home: {
    brand: {
      name: 'I\'AM Works',
      tagline: 'Stay Wild & Free',
      description: 'Premium riding apparel built from custom culture, streetwear energy, and the freedom of the open road.'
    },
    navigation: [
      { label: 'Home', href: '/' },
      { label: 'Shop', href: '/shop' },
      { label: 'Collections', href: '/collections' },
      { label: 'Community', href: '/community' },
      { label: 'About', href: '/about' }
    ],
    hero: {
      eyebrow: 'Engineered for Freedom',
      title: 'Riding apparel and gear built for the wild ones.',
      scriptText: 'Stay Wild & Free',
      description:
        'Dark premium essentials for riders who live between garage nights, city streets, and long-road escapes.',
      ctaLabel: 'Shop Now',
      ctaHref: '/shop',
      image: images.hero,
      features: [
        { title: 'Premium Quality', description: 'Built to last' },
        { title: 'Free Shipping', description: 'Orders over 1.000K' },
        { title: 'Easy Returns', description: '30 day return policy' },
        { title: 'Secure Payment', description: 'Protected checkout' }
      ]
    },
    newCollection: productCatalog.slice(0, 4),
    footer
  },
  products: {
    title: 'Shop All',
    summary: 'Showing 1–8 of 8 results',
    categories: ['Hoodie', 'Crewneck', 'T-Shirt', 'Flannel', 'Jacket', 'Gloves', 'Accessories', 'Limited Edition'],
    filters: {
      sizes: ['S', 'M', 'L', 'XL', 'XXL'],
      colors: [
        { name: 'Black', hex: '#0b0b0b' },
        { name: 'Stone', hex: '#c8c7c3' },
        { name: 'Olive', hex: '#6f7756' },
        { name: 'Signal Red', hex: '#f53935' }
      ],
      series: ['Bloodthorn', 'Neuro', 'Clown Psycho', 'Dominus Noctis', 'Black Voltage', 'Chrome Phantom']
    },
    products: productCatalog
  },
  collections: {
    hero: {
      name: 'Bloodthorn Collection',
      title: 'Bleed, rise, conquer.',
      description:
        'A premium drop inspired by the thorn of life—dark graphics, heavyweight bases, and details made for riders who move through the city like a warning.',
      ctaLabel: 'Explore Collection',
      image: images.collection
    },
    products: productCatalog.filter((item) => item.series === 'Bloodthorn' || item.series === 'Riding Accessories').slice(0, 4)
  },
  community: {
    title: 'Community',
    subtitle: 'Built by riders, for riders.',
    tabs: ['Customer Gallery', 'Rider Stories', 'Events', 'Bike Feature'],
    posts: [
      { title: 'Sunday morning run through the city', image: images.post1, tag: 'Customer Gallery' },
      { title: 'Garage conversations after dark', image: images.post2, tag: 'Rider Stories' },
      { title: 'BBQ ride night in Jakarta', image: images.post3, tag: 'Events' },
      { title: 'Mooneyes Yokohama inspiration board', image: images.post4, tag: 'Bike Feature' },
      { title: 'Customfest crew check-in', image: images.post5, tag: 'Events' },
      { title: 'Built from chrome, grit, and patience', image: images.post6, tag: 'Bike Feature' }
    ]
  },
  about: {
    title: 'We Are',
    accentTitle: 'I\'AM Works',
    description:
      'Born from the garage and raised on the road, I\'AM Works is more than clothing. It is a statement of freedom, creativity, and brotherhood for riders who never blend in.',
    scriptText: 'Stay Wild & Free',
    ctaLabel: 'Our Story',
    heroImage: images.about
  }
};

export function getFallbackProduct(slug) {
  return (
    productDetails[slug] || {
      slug,
      name: 'I\'AM Works Essential',
      price: 459000,
      currency: 'IDR',
      rating: 4.8,
      reviewCount: 18,
      description:
        'Signature essential built for daily rides, workshop sessions, and weekends spent chasing the next route.',
      highlights: ['Premium cotton base', 'Oversize street fit', 'Soft brushed interior', 'Motorculture graphic system'],
      sizes: ['S', 'M', 'L', 'XL'],
      gallery: [images.gallery1, images.gallery2, images.gallery3],
      series: 'Core',
      category: 'Apparel',
      related: productCatalog.slice(0, 4)
    }
  );
}
