import { useEffect, useMemo, useRef, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { apiClient, deriveProductAttributes } from '../api/client';
import FilterSidebar from '../components/FilterSidebar';
import LoadingState from '../components/LoadingState';
import ProductCard from '../components/ProductCard';
import { useGsapReveal } from '../hooks/useGsapReveal';
import { useApi } from '../hooks/useApi';

function parseSeriesFilter(searchParams) {
  return searchParams
    .getAll('series')
    .flatMap((value) => value.split(','))
    .map((value) => value.trim())
    .filter(Boolean);
}

export default function ShopPage() {
  const [searchParams] = useSearchParams();
  const { data, loading } = useApi(apiClient.getProducts, []);
  const scopeRef = useRef(null);
  const [selectedCategory, setSelectedCategory] = useState('');
  const [selectedSize, setSelectedSize] = useState('');
  const [selectedColor, setSelectedColor] = useState('');
  const [selectedSeries, setSelectedSeries] = useState([]);
  const [sortBy, setSortBy] = useState('newest');

  useEffect(() => {
    if (!data) {
      return;
    }

    const requestedCategory = searchParams.get('category') || '';
    const requestedSeries = parseSeriesFilter(searchParams);

    setSelectedCategory(data.categories.includes(requestedCategory) ? requestedCategory : '');
    setSelectedSeries(requestedSeries.filter((series) => data.filters.series.includes(series)));
  }, [data, searchParams]);

  const filteredProducts = useMemo(() => {
    if (!data) {
      return [];
    }

    let results = data.products.filter((product) => {
      const attributes = deriveProductAttributes(product.slug, data.filters);
      const categoryMatch = !selectedCategory || product.category === selectedCategory;
      const sizeMatch = !selectedSize || attributes.sizes.includes(selectedSize);
      const colorMatch = !selectedColor || attributes.colors.includes(selectedColor);
      const seriesMatch = !selectedSeries.length || selectedSeries.includes(product.series);

      return categoryMatch && sizeMatch && colorMatch && seriesMatch;
    });

    if (sortBy === 'price-low') {
      results = [...results].sort((a, b) => a.price - b.price);
    } else if (sortBy === 'price-high') {
      results = [...results].sort((a, b) => b.price - a.price);
    } else {
      results = [...results].sort((a, b) => b.slug.localeCompare(a.slug));
    }

    return results;
  }, [data, selectedCategory, selectedSize, selectedColor, selectedSeries, sortBy]);

  useGsapReveal(scopeRef, [data, filteredProducts.length]);

  function toggleSeries(series) {
    setSelectedSeries((current) =>
      current.includes(series) ? current.filter((item) => item !== series) : [...current, series]
    );
  }

  if (loading && !data) {
    return <LoadingState label="Loading shop inventory..." />;
  }

  return (
    <div ref={scopeRef} className="container page-stack">
      <div className="page-title-row" data-animate="fade-up">
        <div>
          <p className="section-eyebrow">Storefront</p>
          <h1>{data.title}</h1>
          <p className="page-summary">{filteredProducts.length} items available for the next ride.</p>
        </div>
        <label className="sort-control">
          <span>Sort By:</span>
          <select value={sortBy} onChange={(event) => setSortBy(event.target.value)}>
            <option value="newest">Newest</option>
            <option value="price-low">Price: Low to High</option>
            <option value="price-high">Price: High to Low</option>
          </select>
        </label>
      </div>

      <div className="shop-layout">
        <FilterSidebar
          categories={data.categories}
          filters={data.filters}
          selectedCategory={selectedCategory}
          selectedSize={selectedSize}
          selectedColor={selectedColor}
          selectedSeries={selectedSeries}
          onCategory={setSelectedCategory}
          onSize={setSelectedSize}
          onColor={setSelectedColor}
          onSeries={toggleSeries}
        />

        <section className="shop-results" data-animate="fade-up">
          <div className="product-grid" data-animate="stagger">
            {filteredProducts.map((product, index) => (
              <ProductCard key={product.slug} product={product} priority={index < 2} />
            ))}
          </div>
        </section>
      </div>
    </div>
  );
}
