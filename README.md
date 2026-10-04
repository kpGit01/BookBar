Book Management REST API

A lightweight Spring Boot RESTful API application for managing books. Built using Spring Boot, Spring Data JPA, MySQL, and Lombok.

🚀 Tech Stack

Java: 17

Framework: Spring Boot 3.x

Database: MySQL

ORM: Spring Data JPA / Hibernate

Boilerplate Reduction: Lombok

Build Tool: Maven

🛠️ Prerequisites

Make sure you have the following installed on your machine:

Java Development Kit (JDK 17)

Apache Maven

MySQL Server

Postman or any API client (for testing)

⚙️ Configuration & Setup

1. Database Configuration

Open your MySQL terminal or client and create a new database:

CREATE DATABASE bookdb;


2. Configure application.properties

Navigate to src/main/resources/application.properties and update your database credentials:

server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/bookdb?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect


🏃 Running the Application

Navigate to the project root directory in your terminal and execute:

mvn spring-boot:run


The application will start on http://localhost:8080.

📌 API Endpoints

Base URL: http://localhost:8080/api/books

Method

Endpoint

Description

Request Body / Query Params

POST

/addBook

Add a new book to the database

JSON object

GET

/getBook

Retrieve a book by its title

Query parameter: name

🧪 Testing with Postman / cURL

1. Add a Book (POST)

URL: http://localhost:8080/api/books/addBook

Method: POST

Headers: Content-Type: application/json

Body (raw JSON):

{
  "title": "The Pragmatic Programmer",
  "author": "Andrew Hunt",
  "genre": "Software Engineering"
}


Sample Response (201 Created):

{
  "id": 1,
  "title": "The Pragmatic Programmer",
  "author": "Andrew Hunt",
  "genre": "Software Engineering"
}


2. Get Book by Name (GET)

URL: http://localhost:8080/api/books/getBook?name=The Pragmatic Programmer

Method: GET

Sample Response (200 OK):

{
  "id": 1,
  "title": "The Pragmatic Programmer",
  "author": "Andrew Hunt",
  "genre": "Software Engineering"
}


📁 Project Structure

src/main/java/com/SpringSecurity/demo/
├── Controller/
│   └── BookController.java
├── Pojo/
│   └── Book.java
├── Repository/
│   └── BookRepository.java
└── Service/
    └── BookService.java
