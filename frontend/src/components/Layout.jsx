import { Outlet } from 'react-router-dom';
import { apiClient } from '../api/client';
import { useApi } from '../hooks/useApi';
import SiteFooter from './SiteFooter';
import SiteHeader from './SiteHeader';

export default function Layout() {
  const { data } = useApi(apiClient.getHome, []);

  return (
    <div className="app-shell">
      <SiteHeader brand={data?.brand} navigation={data?.navigation} />
      <main className="page-shell">
        <Outlet />
      </main>
      <SiteFooter footer={data?.footer} brand={data?.brand} />
    </div>
  );
}
