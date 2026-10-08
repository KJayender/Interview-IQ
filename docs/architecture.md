# Architecture

The V1 is a modular monolith. Spring Boot owns identity, student profile, question bank, assessment attempts, scoring, and result history. React owns navigation, forms, assessment interaction, charts, and roadmap progress.

```text
React (Vite) → REST controllers → services → Spring Data JPA → MySQL
                                   └→ AIService → Gemini (optional)
```

Authentication uses stateless JWTs and BCrypt. Controllers return DTOs rather than entities. Assessment question DTOs omit answer keys. MCQ scoring is deterministic; written evaluation uses Gemini when configured and falls back to transparent keyword coverage when offline. AI JSON is parsed and schema-checked before it can enter the question bank. Seed questions make local demos possible without a key.

The current schema includes users, question bank/options, assessment attempts, and assessment-to-question joins. Further normalized tables for reusable skill taxonomy, roadmap records, and audit logs can be added as those workflows mature.
