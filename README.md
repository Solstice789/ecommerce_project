# ecommerce_skeleton

Decoupled Ecommerce Listing Skeleton using:

- **Frontend:** React, Next.js (App Router)
- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL

The application can be started either:

- with **Docker Compose** (recommended for quick start)
- with **local development setup** (Node + JDK + PostgreSQL)

---

# Quick Start (Docker)

Make sure Docker (Docker Desktop on Windows) is running.

```bash
docker compose up --build
```

Browse:

- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api/products
- Swagger UI: http://localhost:8080/swagger-ui/index.html

---

# Prerequisites

You can run the project using **Docker** or a **local development setup**.

## Option 1 — Docker (Recommended)

Required:

- Docker
- Docker Compose

This runs the **frontend, backend, and database together**.

## Option 2 — Local Development Setup

Install the following:

- Node.js (v18+)
- JDK 21
- PostgreSQL (v14+)
- Maven (or use the included Maven wrapper)

---

# Database Setup

The backend requires a PostgreSQL database containing a `products` table.

## Option 1 — Docker Database (Automatic)

Running Docker Compose will automatically create the database.

Example configuration used by the containers:

- host: localhost  
- port: 5432  
- database: ecommerce  
- username: postgres  
- password: postgres  

Example docker-compose snippet:

```yaml
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: ecommerce
      POSTGRES_USER: root
      POSTGRES_PASSWORD: toor
    ports:
      - "5432:5432"
```

---

## Option 2 — Local PostgreSQL Setup

Create the database:

```sql
CREATE DATABASE ecommerce;
```

Create the products table:

```sql
CREATE TABLE products (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(10,2),
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);
```

---

# Start Backend

Navigate to the backend directory:

```bash
cd backend
```

Run using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or build and run:

```bash
./mvnw clean package
java -jar target/*.jar
```

Backend runs at:

```text
http://localhost:8080
```

---

# Start Frontend

Navigate to the frontend directory:

```bash
cd frontend
npm install
npm run dev
```

Frontend runs at:

```text
http://localhost:3000
```

---

# Verify

1. Open:

```text
http://localhost:3000
```

---

# API

Products API endpoint:

```text
GET /api/products
POST /api/products
```

Swagger documentation:

```text
http://localhost:8080/swagger-ui/index.html
```
