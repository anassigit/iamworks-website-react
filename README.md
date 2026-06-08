# I'AM Works Website Template

Mobile-first full-stack template for an I'AM Works-style storefront:

- `frontend\`: React + Vite + Bun, responsive layout, GSAP animation, GitHub Pages-ready
- `backend\`: Spring Boot + H2 dummy-data API, Render-ready

## Stack

| Layer | Tech |
| --- | --- |
| Frontend | React 18, Vite 5, Bun, GSAP |
| Backend | Spring Boot 3, Java 17, Spring Web, Spring Data JPA, H2 |
| Frontend hosting | GitHub Pages |
| Backend hosting | Render free web service |

## What is included

- Mobile-first responsive storefront
- Animated burger navigation for smaller screens
- GSAP reveal and scroll-based motion with reduced-motion support
- Shop, product detail, collections, community, about, and placeholder support pages
- Dummy backend content persisted in H2 at runtime
- GitHub Pages workflow for the frontend
- `render.yaml` and Docker-based deployment setup for the backend

## Prerequisites

- Bun 1.1+
- Java 17

> The backend requires Java 17. If `java -version` shows Java 8, switch `JAVA_HOME` before running Maven.

## Run locally

### Backend

```powershell
Set-Location .\backend
$env:JAVA_HOME = 'C:\path\to\jdk-17'
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
.\mvnw.cmd spring-boot:run
```

Backend URL: `http://localhost:8080`

Endpoints:

- `GET /api/home`
- `GET /api/products`
- `GET /api/products/{slug}`
- `GET /api/collections`
- `GET /api/community`
- `GET /api/about`
- `GET /api/health`

### Frontend

```powershell
Set-Location .\frontend
bun install
bun run dev
```

Frontend URL: `http://localhost:5173`

Local frontend API target:

```powershell
frontend\.env.example
```

with:

```env
VITE_API_URL=http://localhost:8080
```

## Frontend deployment to GitHub Pages

The frontend is already prepared for GitHub Pages with:

- Vite base path: `/iamworks-website-react/`
- `HashRouter` for static-host-safe routing
- workflow: `.github\workflows\deploy-frontend.yml`

### Required repository setup

1. Create a GitHub repository named **`iamworks-website-react`** under **`anassigit`**.
2. Push this project to the `main` branch.
3. In the repository settings, enable **GitHub Pages** with **GitHub Actions** as the source.
4. Add a repository variable named `VITE_API_URL` with your deployed backend URL, for example:

```text
https://your-render-service.onrender.com
```

5. The workflow will publish the built frontend to:

```text
https://anassigit.github.io/iamworks-website-react/
```

### Manual build target

```powershell
Set-Location .\frontend
bun run build
```

## Backend deployment to Render

The backend is prepared for a free **Render** web service with:

- `render.yaml`
- `backend\Dockerfile`
- env-driven `PORT`
- prod/local Spring profiles
- configurable CORS via `APP_CORS_ALLOWED_ORIGIN_PATTERNS`

### Deploy on Render

1. Push this repository to GitHub.
2. In Render, create a new Blueprint or Web Service from the repository.
3. Use the included `render.yaml`, or point the service at `backend\`.
4. Keep these environment values:

```text
SPRING_PROFILES_ACTIVE=prod
APP_CORS_ALLOWED_ORIGIN_PATTERNS=https://anassigit.github.io
```

5. After deploy, copy the Render URL and set it as `VITE_API_URL` in the GitHub repository variable for the frontend workflow.

> Render free services can sleep after inactivity, so the first API request may be slow.

## Validation

- Frontend production build: `bun run build` ✅
- Backend tests: `.\mvnw.cmd test` with Java 17 active

## Important limitation

This workspace was not connected to an existing Git repository or GitHub repository, so the app could be prepared for deployment but not actually published from here. To complete the live deploy, create/push the repo and let GitHub Actions + Render run the included configuration.
