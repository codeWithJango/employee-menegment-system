# Employee Management System

A Spring Boot REST API for managing employee records. It uses Spring Data JPA with PostgreSQL for persistence and Redis for caching employee lookups.

## Features

- List all employees
- Create an employee
- Retrieve an employee by ID
- Update an employee
- Cache employee-by-ID lookups in Redis (one-minute cache entry lifetime)
- OpenAPI documentation and Swagger UI

## Technology

- Java 17
- Spring Boot 4.1.2
- Maven
- Spring Web MVC and Spring Data JPA
- PostgreSQL
- Redis
- Springdoc OpenAPI

## Prerequisites

- JDK 17 or newer
- PostgreSQL
- Redis

The application defaults to port `8088`, PostgreSQL at `localhost:5432` with database `shoping`, and Redis at `localhost:6379`.

## Configuration

Review `src/main/resources/application.properties` and make sure the database and Redis services are reachable before starting the application. Create the PostgreSQL database `shoping` (or change the configured JDBC URL to use another database).

Do not commit passwords or other secrets. Supply database credentials through environment variables or another local, untracked configuration source. Spring Boot supports environment-variable overrides, including:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_DATA_REDIS_HOST`
- `SPRING_DATA_REDIS_PORT`
- `SERVER_PORT`

Hibernate is configured with `spring.jpa.hibernate.ddl-auto=update`; the application updates the schema based on its JPA entities. Review this setting before using the application with important data.

## Run locally

From the project directory, start PostgreSQL and Redis, then run:

**Windows (PowerShell):**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

The API is available at `http://localhost:8088`.

## REST API

All endpoints use JSON where a request body is required.

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/employee` | List employees |
| `POST` | `/employee` | Create an employee |
| `GET` | `/employee/{id}` | Get an employee by ID |
| `PUT` | `/employee/{id}` | Update an employee |

Employee request body:

```json
{
  "id": 1,
  "firstname": "Ada",
  "lastname": "Lovelace",
  "salary": 95000.0
}
```

The `id` is supplied by the client; the current entity does not configure automatic ID generation. Fetching an ID that does not exist returns `404 Not Found`.

### Example requests

```bash
curl http://localhost:8088/employee
```

```bash
curl -X POST http://localhost:8088/employee \
  -H "Content-Type: application/json" \
  -d '{"id":1,"firstname":"Ada","lastname":"Lovelace","salary":95000.0}'
```

```bash
curl http://localhost:8088/employee/1
```

```bash
curl -X PUT http://localhost:8088/employee/1 \
  -H "Content-Type: application/json" \
  -d '{"firstname":"Ada","lastname":"Byron","salary":98000.0}'
```

Swagger UI is available at `http://localhost:8088/swagger-ui/index.html`; the OpenAPI specification is at `http://localhost:8088/v3/api-docs`.

## Build and test

Run the test suite:

```powershell
.\mvnw.cmd test
```

Package the application:

```powershell
.\mvnw.cmd package
```

On Linux/macOS, replace `.\mvnw.cmd` with `./mvnw`.

## GitHub notes

The `.gitignore` excludes generated build output such as `target/`. Before pushing, verify that local credentials and environment-specific configuration have not been added to tracked files. This API currently allows cross-origin requests from `http://localhost:4200` and does not configure authentication; review both settings before exposing it beyond local development.
