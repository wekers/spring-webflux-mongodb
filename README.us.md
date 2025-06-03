## Language
- [Portuguese version of the README content](README.md) <br/>
- [English version of the README content](README.us.md)
---
<p align="left">
  <img src="https://img.shields.io/static/v1?label=Objective:&message=Convert%20to%20Reactive%20WebFlux&color=8257E5&labelColor=000000" alt="Challenge" />
</p>

## Convert the project to a Reactive Back-end with Spring WebFlux

## 📝 DSPosts API

RESTful API built with **Java + Spring Boot** and persistence in **MongoDB**.  
It allows managing users, posts, and comments.

---

## 📐 Class Diagram

![Diagram](https://raw.githubusercontent.com/wekers/spring-webflux-mongodb/refs/heads/main/model-spring-mongodb.png)

The API structure follows the model below:

```
User 1 ────── * Post 1 ────── * Comment

User
├─ id: String
├─ name: String
└─ email: String

Post
├─ id: String
├─ date: Date
├─ title: String
├─ body: String
└─ author: User

Comment
├─ id: String
├─ text: String
├─ date: Date
└─ author: User
```

---

## 🚀 Available Endpoints

> Base URL: `http://localhost:8080` (or replace with your `{{host}}`)

### 👤 User

| Method | Endpoint | Description |
|--------|----------|-----------|
| GET    | `/users` | List all users |
| GET    | `/users/{id}` | Get user by ID |
| GET    | `/users/{id}/posts` | Get posts from a specific user |
| GET	 | `/posts/user/{id}`	| Get posts from a specific user |
| POST   | `/users` | Create a new user |
| PUT    | `/users/{id}` | Update a existing user |
| DELETE | `/users/{id}` | Delete a user |

### 📝 Post

| Method | Endpoint | Description |
|--------|----------|-----------|
| GET    | `/posts/{id}` | Get post by ID |
| GET    | `/posts/titlesearch?text=xyz` | Search post by title |
| GET    | `/posts/fullsearch?text=xyz&start=yyyy-MM-ddTHH:mm:ssZ&end=yyyy-MM-ddTHH:mm:ssZ` | Full search with text and date range filters |
<br/>

## 🚀 Project Execution

- **OBS: Make a clone of the project**
- `chmod +x mvnw`

### 📦 Start MongoDB via Docker

```bash
docker-compose up -d
```

---

## ▶️ Running the Application <br/>
### 🛠️ Development Environment

1. Make sure MongoDB is running:
```docker ps```
2. Run the `dev` profile:
```./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```
<br/>This profile is intended for accessing local MongoDB (Docker).

---

## ▶️ Running the Application <br/>
### 🌐 Production Environment

1. Create a .env file with your MongoDB Atlas URI, for example:

```bash
MONGO_URI="mongodb+srv://user:password@cluster0.sdgd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0-google-webflux-mongo"
MONGO_DB=workshop_mongo
```

2. Export environment variables:

* For Bash/Zsh:

```bash
export $(grep -v '^#' .env | xargs)
```

* For Fish shell (using a helper file):
```bash
source load-env.fish
```

3. Run the application using the `prod` profile:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```
**The `prod` profile uses the MongoDB Atlas URI defined via environment variables.**

💾 Connecting with MongoDB Compass

🔌 Local MongoDB (via Docker)
`mongodb://devuser:devpass@localhost:27018/workshop_mongo?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&ssl=false`

☁️ MongoDB Atlas (cloud)

Copy the URI provided by MongoDB Atlas and insert your credentials, for example:
`mongodb+srv://user:password@cluster0.lgfdgdfkqhz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0-google-webflux-mongo`

---

## 🔗 Postman Collection

Import the collection and easily test the endpoints with Postman:


[📂 Access DSPosts Collection](https://raw.githubusercontent.com/wekers/spring-webflux-mongodb/refs/heads/main/Workshop%20Webflux%20MongoDB.postman_collection.json)

---

## 🛠️ Technologies


- Java 17+
- Spring Boot
- Spring Data Reactive MongoDB
- MongoDB
- Postman

