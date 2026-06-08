export default function FilterSidebar({
  categories = [],
  filters,
  selectedCategory,
  selectedSize,
  selectedColor,
  selectedSeries,
  onCategory,
  onSize,
  onColor,
  onSeries
}) {
  return (
    <aside className="filter-sidebar" data-animate="fade-up">
      <div className="filter-block">
        <p className="filter-title">Categories</p>
        <div className="filter-links">
          <button type="button" className={!selectedCategory ? 'filter-link active' : 'filter-link'} onClick={() => onCategory('')}>
            All
          </button>
          {categories.map((category) => (
            <button
              type="button"
              key={category}
              className={selectedCategory === category ? 'filter-link active' : 'filter-link'}
              onClick={() => onCategory(category)}
            >
              {category}
            </button>
          ))}
        </div>
      </div>

      <div className="filter-block">
        <p className="filter-title">Size</p>
        <div className="chip-list">
          {filters.sizes.map((size) => (
            <button
              type="button"
              key={size}
              className={selectedSize === size ? 'size-chip active' : 'size-chip'}
              onClick={() => onSize(selectedSize === size ? '' : size)}
            >
              {size}
            </button>
          ))}
        </div>
      </div>

      <div className="filter-block">
        <p className="filter-title">Color</p>
        <div className="color-swatches">
          {filters.colors.map((color) => (
            <button
              type="button"
              key={color.name}
              title={color.name}
              className={selectedColor === color.name ? 'color-dot active' : 'color-dot'}
              style={{ '--dot-color': color.hex }}
              onClick={() => onColor(selectedColor === color.name ? '' : color.name)}
            />
          ))}
        </div>
      </div>

      <div className="filter-block">
        <p className="filter-title">Series</p>
        <div className="checkbox-list">
          {filters.series.map((series) => (
            <label key={series} className="check-item">
              <input
                type="checkbox"
                checked={selectedSeries.includes(series)}
                onChange={() => onSeries(series)}
              />
              <span>{series}</span>
            </label>
          ))}
        </div>
      </div>
    </aside>
  );
}
