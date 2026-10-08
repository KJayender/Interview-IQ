# Interview-IQ

Prepare Smarter. Practice Better. Get Interview Ready.

Interview-IQ is a Java-first interview preparation MVP with a React interface. It guides a candidate through a structured assessment, deterministic MCQ scoring, skill gap review, and a practical next-step roadmap. Gemini is optional and runs only from the Spring Boot service; the app remains demonstrable with its seeded question bank when no API key is configured.

## Stack

- Java 21, Spring Boot 3.4, Spring Web, Validation, Spring Data JPA, Spring Security, MySQL
- React 18, Vite, React Router, Axios, Recharts 
- JWT bearer authentication, BCrypt password hashing

## Run locally

1. Install Java 21, Maven, Node.js 20+, and MySQL 8.
2. Copy `.env.example` to `.env` and set database credentials and a long random `JWT_SECRET` (at least 32 characters). `GEMINI_API_KEY` is optional.
   To provision an admin on startup, set both `ADMIN_EMAIL` and `ADMIN_PASSWORD` (minimum 8 characters); leave them blank for student-only local use.
3. Start the API from `backend` with `mvn spring-boot:run`.
4. Start the UI from `frontend` with `npm install` then `npm run dev`.
5. Open http://localhost:5173. Register a student account; seeded demo questions can be used without Gemini.

Compose is also available with `docker compose up --build` after configuring `.env`.

API docs are exposed at `/swagger-ui/index.html`. API base URL is `http://localhost:8080/api`.

## Product flow and architecture

The frontend is organized into pages, reusable components, context, and a centralized API client. The backend follows controller/service/repository/entity/DTO boundaries. Assessment question generation and answer evaluation use an `AIService` abstraction with a Gemini implementation and deterministic/sample fallback. MCQ scoring is always performed in Java. The result model aggregates scores by topic and produces strong areas, improvement areas, and roadmap actions.

Core routes: `/`, `/login`, `/register`, `/onboarding`, `/dashboard`, `/assessments/create`, `/assessments/:id`, `/assessments/:id/result`, `/roadmap`, `/progress`, `/admin`.

## Configuration

See `.env.example`. No credentials belong in source control. For local development, Spring reads environment variables directly; Docker Compose reads `.env`.

## Scope

V1 focuses on text assessments, skill gaps, roadmap tracking, and progress. Video, emotion analysis, marketplaces, and payments are intentionally excluded. Scores are preparation feedback, not a hiring prediction or psychological measurement.
