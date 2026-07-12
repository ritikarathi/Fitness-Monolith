# AI-Powered Fitness Monolith

A secure **Spring Boot** RESTful backend application that enables users to manage their fitness journey through activity tracking, secure authentication, and **AI-powered personalized fitness recommendations using the Google Gemini API**.

Built with a scalable layered architecture, JWT authentication, Spring Security, and Spring Data JPA.

---

# Overview

Fitness Monolith is a production-style backend application designed to demonstrate modern Java backend development.

The application provides secure REST APIs for:

- User Authentication
- Activity Tracking
- User Management
- AI-powered Personalized Recommendations
- Recommendation Management

The project combines traditional backend engineering with Generative AI by integrating **Google Gemini**, allowing users to receive intelligent, context-aware fitness guidance based on their goals and activity history.

---

# Features

## Authentication & Authorization

- User Registration
- Secure Login
- JWT Authentication
- BCrypt Password Encryption
- Spring Security
- Role-based Protected APIs

---

## User Management

- Register new users
- Login securely
- View Profile
- Update Profile
- Delete Account

---

## Activity Management

Users can record fitness activities including:

- Workout Type
- Duration
- Calories Burned
- Activity Date
- Notes

Operations:

- Create Activity
- View Activity History
- Update Activity
- Delete Activity

---

## AI-Powered Fitness Recommendations (Gemini API)

Integrated **Google Gemini API** to generate personalized fitness suggestions based on user activity and goals.

### AI Features

- Personalized workout recommendations
- Recovery suggestions
- Fitness tips
- Motivation messages
- Goal-specific exercise plans
- Lifestyle improvement suggestions
- Healthy habit recommendations

Example Prompt:

> "Generate a personalized workout recommendation for a user who completed a 5km run, burned 450 calories, and wants to lose weight."

The AI-generated response is securely returned through REST APIs.

---

## Recommendation Management

- Store recommendations
- Retrieve previous recommendations
- Update recommendations
- Delete recommendations

Recommendations can be generated either:

- manually
- automatically using Gemini AI

---

# Database Relationships

The application demonstrates relational database mapping using Spring Data JPA.

```
User
 │
 ├── Activity
 │      │
 │      └── Recommendation
 │
 ├── Activity
 │      │
 │      └── Recommendation
```

Relationships:

- One User → Many Activities
- One Activity → Many Recommendations

Implemented using:

- @OneToMany
- @ManyToOne

ensuring referential integrity and efficient data retrieval.

---

# Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring MVC | REST API Development |
| Spring Security | Authentication & Authorization |
| JWT | Stateless Authentication |
| Spring Data JPA |
| MySQL | Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |
| Google Gemini API | AI Recommendation Engine |

---

# AI Workflow

```
          User
            │
            ▼
     Submit Activity
            │
            ▼
   Spring Boot REST API
            │
            ▼
    Gemini Service Layer
            │
            ▼
Google Gemini API
            │
            ▼
 AI Generated Recommendation
            │
            ▼
 Save Recommendation
            │
            ▼
 Return Response
```

---

# Authentication Flow

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
Authenticate User
   │
   ▼
Generate JWT
   │
   ▼
Client Stores Token
   │
   ▼
Protected APIs
   │
   ▼
JWT Authentication Filter
   │
   ▼
Controller
```

---

# REST API Modules

## Authentication

- Register User
- Login User

---

## Users

- Create User
- Get User
- Update User
- Delete User

---

## Activities

- Create Activity
- Get Activities
- Update Activity
- Delete Activity

---

## Recommendations

- Create Recommendation
- Get Recommendations
- Update Recommendation
- Delete Recommendation

---

## AI Module

### Generate AI Recommendation

```
POST /api/v1/ai/recommendation
```

Request

```json
{
    "goal":"Weight Loss",
    "activity":"Running",
    "duration":45,
    "caloriesBurned":420
}
```

Example Response

```json
{
  "recommendation":
  "Based on today's running session, continue with interval training twice a week, increase hydration, consume a protein-rich meal after workouts, and include strength training for faster fat loss."
}
```

---

# Project Structure

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
    │      ├── ActivityService
    │      ├── RecommendationService
    │      ├── UserService
    │      └── GeminiService
    │
    ├── util
    └── FitnessMonolithApplication
    │
    └── resources
        ├── application.properties
        └── static
```

---

# Getting Started

## Clone Repository

```bash
git clone https://github.com/ritikarathi/Fitness-Monolith.git
```

```bash
cd Fitness-Monolith
```

---

## Configure Database

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

---

## Configure Gemini API

Create an API key from **Google AI Studio** and add it to your configuration.

```properties
gemini.api.key=YOUR_GEMINI_API_KEY
```

---

## Build Project

```bash
mvn clean install
```

---

## Run

```bash
mvn spring-boot:run
```

Application starts at:

```
http://localhost:8080
```

---

# JWT Authentication

After login, include the JWT token in every protected request.

```
Authorization: Bearer YOUR_TOKEN
```

---

# Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- Spring Validation
- Lombok
- Hibernate
- MySQL
- JJWT
- Google Gemini API
- Maven

---

# Learning Outcomes

This project helped me gain hands-on experience with:

- Spring Boot
- REST API Development
- Spring Security
- JWT Authentication
- Role-based Authorization
- Spring Data JPA
- Entity Relationships
- DTO Mapping
- Exception Handling
- MySQL Integration
- Layered Architecture
- REST Client Integration
- Prompt Engineering
- Google Gemini API Integration
- AI-powered Backend Development
- Production-style Project Structure

---


# Author

## **Ritika Rathi**

**Aspiring Software Engineer | Java Backend Developer | Spring Boot **

GitHub:
https://github.com/ritikarathi/Fitness-Monolith
