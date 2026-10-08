# Interview-IQ API

Requires Java 21+, Maven, and MySQL 8. Configure environment variables from the root `.env.example`, then run `mvn spring-boot:run`. The API listens on port 8080. Set `GEMINI_API_KEY` to enable generated questions and rubric-based written feedback; otherwise seeded questions and a local concept-coverage fallback are used.
