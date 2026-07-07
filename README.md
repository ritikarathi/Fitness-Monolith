# 🏋️ Fitness Monolith

A secure RESTful backend application built using **Spring Boot** that helps users manage their fitness activities and receive personalized recommendations. The project follows a layered architecture and implements JWT-based authentication and authorization using Spring Security.

---

## 📌 Overview

Fitness Monolith is a backend application that provides secure APIs for user authentication, activity management, and personalized recommendations. The application uses relational database mapping with Spring Data JPA to maintain relationships between users, activities, and recommendations.

---

## ✨ Features

### 🔐 Authentication & Authorization

* User Registration
* User Login
* JWT-based Authentication
* Password Encryption using BCrypt
* Spring Security Integration
* Protected REST APIs

### 👤 User Management

* Register new users
* Login with secure authentication
* View and update user profile
* Delete user account

### 🏃 Activity Management

* Create fitness activities
* View activity history
* Update activities
* Delete activities

### 💡 Recommendation Management

* Generate and store personalized recommendations
* Retrieve recommendations associated with a user
* Manage recommendation records

## 🗂 Database Relationships

The application demonstrates relational mapping using JPA/Hibernate:

- One User can have multiple Activities.
- Each Activity belongs to one User.
- One Activity can have multiple Recommendations.
- Each Recommendation belongs to one Activity.

These relationships are implemented using JPA annotations such as `@OneToMany` and `@ManyToOne`, ensuring efficient data retrieval and maintaining referential integrity.

---

# 🛠 Tech Stack

| Technology      | Purpose                        |
| --------------- | ------------------------------ |
| Java 21         | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring MVC      | REST API Development           |
| Spring Security | Authentication & Authorization |
| JWT             | Stateless Authentication       |
| Spring Data JPA | Database Access                |
| MySQL           | Relational Database            |
| Maven           | Dependency Management          |
| Lombok          | Boilerplate Code Reduction     |

---

# 📁 Project Structure

```
src
└── main
    ├── java
    │
    ├── config
    ├── controller
    ├── dto
    ├── entity
    ├── repository
    ├── security
    ├── service
    └── FitnessMonolithApplication
    │
    └── resources
        ├── application.properties
        └── static
```

---

# 🔐 Authentication Flow

```
Client
   │
   ▼
Register / Login
   │
   ▼
Spring Security
   │
   ▼
Authenticate Credentials
   │
   ▼
Generate JWT
   │
   ▼
Client Stores Token
   │
   ▼
Protected API Requests
   │
   ▼
JWT Filter
   │
   ▼
Controller
```

---

# 📡 API Modules

### Authentication

* Register User
* Login User

### Users

* Create User
* Get User Details
* Update User
* Delete User

### Activities

* Create Activity
* Get Activities
* Update Activity
* Delete Activity

### Recommendations

* Create Recommendation
* Get Recommendations
* Update Recommendation
* Delete Recommendation

---

# ⚙️ Getting Started

## Clone Repository

```bash
git clone https://github.com/ritikarathi/Fitness-Monolith.git
```

```bash
cd Fitness-Monolith
```

---

## Configure Database

Update your `application.properties`:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## Build the Project

```bash
mvn clean install
```

---

## Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

# 🔑 JWT Authentication

After a successful login, the application returns a JWT token.

Include it in the Authorization header for all protected endpoints:

```
Authorization: Bearer <JWT_TOKEN>
```

---

# 📦 Dependencies

* Spring Boot Starter Web
* Spring Boot Starter Security
* Spring Boot Starter Data JPA
* Spring Validation
* MySQL
* Lombok
* JJWT
* Maven

---

# 🎯 Learning Outcomes

Through this project, I gained practical experience with:

* Spring Boot application development
* Building RESTful APIs
* Spring Security configuration
* JWT Authentication
* Entity relationships using Spring Data JPA
* MySQL database integration
* Layered architecture (Controller → Service → Repository)
* DTO-based request and response handling

---

# 👩‍💻 Author

**Ritika Rathi**

Aspiring Software Engineer | Java Backend Developer | Spring Boot Enthusiast

GitHub: https://github.com/ritikarathi/Fitness-Monolith

