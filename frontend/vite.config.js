import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig(({ mode }) => ({
  base: mode === 'production' ? '/iamworks-website-react/' : '/',
  plugins: [react()],
  server: {
    port: 5173
  }
}));
