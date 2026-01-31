
# HelloApp – Spring Boot Backend Mastery Project

This project is a progressive, production-minded Spring Boot backend application built step by step to cover real-world backend engineering concepts.

---

## Tech Stack
- Java 21
- Spring Boot 3.2.x
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Jakarta Validation

---

## Core Features
- Clean layered architecture (Controller, Service, Repository)
- RESTful APIs
- DTO-based response shaping
- Pagination & sorting
- Search APIs
- Soft delete (active flag)
- Centralized exception handling

---

## API Endpoints

### Create User
POST /users

### Get User by ID
GET /users/{id}

### Get Users (Pagination + Sorting + Search)
GET /users?page=0&size=5&sortBy=name  
GET /users?search=saddam

### Update User
PUT /users/{id}

### Partial Update
PATCH /users/{id}

### Delete User (Soft Delete)
DELETE /users/{id}

---

## Sample Request/Response

### Create User
**Request:**
```json
POST /users
{
  "name": "Saddam",
  "email": "saddam@example.com",
  "age": 25
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Saddam",
  "age": 25
}
```

### Get User by ID
**Response:**
```json
GET /users/1
{
  "id": 1,
  "name": "Saddam",
  "age": 25
}
```

### Get Users (Paginated)
**Response:**
```json
GET /users?page=0&size=2&sortBy=name
{
  "content": [
    { "id": 1, "name": "Saddam", "age": 25 },
    { "id": 2, "name": "Alex", "age": 30 }
  ],
  "pageable": { ... },
  "totalElements": 10,
  "totalPages": 5
}
```

### Partial Update (PATCH)
**Request:**
```json
PATCH /users/1
{
  "age": 26
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Saddam",
  "age": 26
}
```

---

## Pagination Example
GET /users?page=1&size=2&sortBy=age

---

## Database
H2 Console:
http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:mem:testdb

---

## Project Structure
```
com.saddy.helloapp
├── controller/
├── service/
├── repository/
├── dto/
├── model/
├── exception/
└── HelloappApplication.java
```

---

## Key Principles
- Entities never exposed directly
- DTOs define API contracts
- Repository layer enforces data visibility
- Soft delete is idempotent
- Database handles filtering and sorting

---

## Author
Built as part of a structured Spring Boot learning journey with production mindset.
