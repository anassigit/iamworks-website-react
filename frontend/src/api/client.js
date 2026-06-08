import { fallbackData, getFallbackProduct } from './fallbackData';

function normalizeApiBaseUrl(value) {
  return value ? value.replace(/\/+$/, '') : '';
}

const configuredApiBaseUrl = normalizeApiBaseUrl(import.meta.env.VITE_API_URL);
const API_BASE_URL = import.meta.env.PROD
  ? configuredApiBaseUrl
  : normalizeApiBaseUrl(configuredApiBaseUrl || 'http://localhost:8080');

function buildApiUrl(path) {
  return API_BASE_URL ? `${API_BASE_URL}${path}` : path;
}

async function fetchJson(path, fallback) {
  try {
    const response = await fetch(buildApiUrl(path), {
      headers: {
        Accept: 'application/json'
      }
    });

    if (!response.ok) {
      throw new Error(`Request failed: ${response.status}`);
    }

    return await response.json();
  } catch (error) {
    return typeof fallback === 'function' ? fallback() : fallback;
  }
}

export const apiClient = {
  getHome: () => fetchJson('/api/home', fallbackData.home),
  getProducts: () => fetchJson('/api/products', fallbackData.products),
  getProductBySlug: (slug) => fetchJson(`/api/products/${slug}`, () => getFallbackProduct(slug)),
  getCollections: () => fetchJson('/api/collections', fallbackData.collections),
  getCommunity: () => fetchJson('/api/community', fallbackData.community),
  getAbout: () => fetchJson('/api/about', fallbackData.about)
};

export function formatCurrency(value, currency = 'IDR') {
  return new Intl.NumberFormat('id-ID', {
    style: 'currency',
    currency,
    maximumFractionDigits: 0
  }).format(value);
}

export function deriveProductAttributes(slug, filters) {
  const base = slug.length;
  const sizes = filters.sizes.filter((_, index) => (index + base) % 2 === 0);
  const colors = filters.colors.filter((_, index) => (index + base) % 3 !== 0).map((item) => item.name);

  return {
    sizes: sizes.length ? sizes : filters.sizes.slice(0, 2),
    colors: colors.length ? colors : filters.colors.slice(0, 2).map((item) => item.name)
  };
}
