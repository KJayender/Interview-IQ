# API outline

All routes use `/api`.

| Method | Route | Access | Purpose |
|---|---|---|---|
| POST | `/auth/register` | Public | Create student account |
| POST | `/auth/login` | Public | Sign in and receive JWT |
| GET/PUT | `/profile` | Student | Read/update preparation profile |
| GET | `/skills`, `/job-roles` | Student | Return role and topic catalogs |
| GET/POST | `/assessments` | Student | List/create attempts |
| GET | `/assessments/{id}` | Owner | Fetch questions (without answers) |
| POST | `/assessments/{id}/submit` | Owner | Score and save a completed attempt |
| GET | `/results/{id}` | Owner | Retrieve evaluated result |
| GET | `/results/history` | Student | Assessment history |
| GET | `/dashboard` | Student | Readiness and history snapshot |

OpenAPI UI is at `/swagger-ui/index.html`.
