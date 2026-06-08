import { useEffect } from 'react';
import { Navigate, Route, Routes, useLocation } from 'react-router-dom';
import Layout from './components/Layout';
import AboutPage from './pages/AboutPage';
import CollectionsPage from './pages/CollectionsPage';
import CommunityPage from './pages/CommunityPage';
import HomePage from './pages/HomePage';
import PlaceholderPage from './pages/PlaceholderPage';
import ProductDetailPage from './pages/ProductDetailPage';
import ShopPage from './pages/ShopPage';

function ScrollToTop() {
  const location = useLocation();

  useEffect(() => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }, [location.pathname]);

  return null;
}

export default function App() {
  return (
    <>
      <ScrollToTop />
      <Routes>
        <Route element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="shop" element={<ShopPage />} />
          <Route path="products/:slug" element={<ProductDetailPage />} />
          <Route path="collections" element={<CollectionsPage />} />
          <Route path="community" element={<CommunityPage />} />
          <Route path="about" element={<AboutPage />} />
          <Route path="iam-garage" element={<PlaceholderPage />} />
          <Route path="journal" element={<PlaceholderPage />} />
          <Route path="contact" element={<PlaceholderPage />} />
          <Route path="support/:topic" element={<PlaceholderPage />} />
          <Route path="*" element={<Navigate to="/" replace />} />
        </Route>
      </Routes>
    </>
  );
}
