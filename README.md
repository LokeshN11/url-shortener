# URL Shortener 🚀

A backend URL Shortener application built using Java, Spring Boot, MySQL, and Spring Data JPA.

---

## Features

* Generate short URLs
* Redirect short URLs to original URLs
* Store URL mappings in MySQL
* REST API support
* Layered architecture

---

## Technologies Used

* Java
* Spring Boot
* MySQL
* Spring Data JPA
* Hibernate
* Maven

---

## API Endpoints

### Generate Short URL

GET /shorten?originalUrl=https://google.com

Example Response:

Short URL: http://localhost:8080/jKF090

---

### Redirect URL

GET /{shortCode}

Example:

http://localhost:8080/jKF090

Redirects to:

https://google.com

---

## Project Structure

src/main/java/com/lokesh/urlshortener

* controller
* service
* repository
* entity

---

## How to Run

1. Clone repository
2. Configure MySQL database
3. Update application.properties
4. Run:

.\mvnw spring-boot:run

---

## Future Improvements

* Redis caching
* Click analytics
* URL expiry
* Docker deployment
* Swagger API documentation

---

## Author

Lokesh Nagasarapu
