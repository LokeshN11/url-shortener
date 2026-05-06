# URL Shortener Application 🚀

A professional backend URL Shortener application built using Java, Spring Boot, Hibernate, and MySQL.

This project allows users to generate shortened URLs, create custom aliases, track click analytics, and test APIs using Swagger UI.

---

# Features

## Core Functionalities

* Generate short URLs dynamically
* Redirect short URLs to original URLs
* Real-time click analytics tracking
* Custom alias support
* Duplicate alias validation
* Swagger OpenAPI documentation
* MySQL database integration
* Layered backend architecture

---

# Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger OpenAPI

---

# Project Architecture

```text
Controller → Service → Repository → MySQL
```

* Controller Layer handles API requests
* Service Layer contains business logic
* Repository Layer interacts with database
* MySQL stores URL mappings and analytics

---

# API Endpoints

## Generate Short URL

```http
GET /shorten?originalUrl=https://google.com
```

Example Response:

```text
Short URL: http://localhost:8080/abc123
```

---

## Generate Custom Alias URL

```http
GET /shorten?originalUrl=https://google.com&customAlias=lokesh
```

Example Response:

```text
Short URL: http://localhost:8080/lokesh
```

---

## Redirect to Original URL

```http
GET /{shortCode}
```

Example:

```http
GET /lokesh
```

Redirects user to original URL.

---

# Swagger API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

Swagger helps developers:

* Understand APIs
* Test endpoints
* View request/response details
* Explore backend functionality interactively

---

# Database Table Example

| id | original_url                             | short_code | click_count |
| -- | ---------------------------------------- | ---------- | ----------- |
| 1  | [https://google.com](https://google.com) | lokesh     | 5           |

---

# How to Run the Project

## Clone Repository

```bash
git clone <your-github-repo-link>
```

---

## Configure MySQL

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/urlshortener
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Run Application

```bash
./mvnw spring-boot:run
```

---

# Learning Outcomes

Through this project:

* Implemented REST APIs using Spring Boot
* Learned layered backend architecture
* Integrated MySQL with JPA/Hibernate
* Implemented URL analytics tracking
* Added validation and custom business logic
* Integrated Swagger OpenAPI documentation
* Debugged real dependency/version compatibility issues

---

# Future Enhancements

This project can be extended further with enterprise-level features.

* URL expiration feature
* User authentication
* Rate limiting
* Redis caching
* Docker deployment
* Cloud deployment

---

# Author

Lokesh Nagasarapu
