## Language
- [Versão em Português do conteúdo do README](README.md) <br/>
- [English version of the README content](README.us.md)
---
<p align="left">
  <img src="https://img.shields.io/static/v1?label=Objetivo:&message=Converter%20para%20WebFlux%20Reativo&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

## Converter o projeto para Back-end Reativo com Spring WebFlux

## 📝 DSPosts API

API RESTful construída com **Java + Spring Boot** e persistência em **MongoDB**. Permite o gerenciamento de usuários, posts e comentários.

---

## 📐 Diagrama de Classes

![Diagrama](https://raw.githubusercontent.com/wekers/spring-webflux-mongodb/refs/heads/main/model-spring-mongodb.png)

A estrutura da API segue o seguinte modelo:

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

## 🚀 Endpoints Disponíveis

> Base URL: `http://localhost:8080` (ou substitua `{{host}}`)

### 👤 User

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/users` | Lista todos os usuários |
| GET    | `/users/{id}` | Retorna um usuário por ID |
| GET    | `/users/{id}/posts` | Retorna os posts de um usuário |
| GET	 | `/posts/user/{id}`	| Retorna os posts de um usuário |
| POST   | `/users` | Cria um novo usuário |
| PUT    | `/users/{id}` | Atualiza um usuário existente |
| DELETE | `/users/{id}` | Remove um usuário |

### 📝 Post

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/posts/{id}` | Retorna um post por ID |
| GET    | `/posts/titlesearch?text=xyz` | Busca posts por título |
| GET    | `/posts/fullsearch?text=xyz&start=yyyy-MM-ddTHH:mm:ssZ&end=yyyy-MM-ddTHH:mm:ssZ` | Busca completa com filtro por texto e intervalo de datas |
<br/>

## 🚀 Execução do Projeto

- **OBS: Faça um clone do projeto**
- `chmod +x mvnw`

### 📦 Como executar o Docker para rodar o (MongoDB)

```bash
docker-compose up -d
```

---

## ▶️ Executando a aplicação <br/>
### 🛠️ Ambiente de Desenvolvimento

1. Certifique-se de que o MongoDB está rodando:
```docker ps```
2. Execute o perfil dev:
```./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```
<br/>Este perfil é para acessar o MongoDB local.

---

## ▶️ Executando a aplicação <br/>
### 🌐 Ambiente de Produção

1. Crie um arquivo .env com a URI do MongoDB Atlas:

ex:
```bash
MONGO_URI="mongodb+srv://usuario:senha@cluster0.sdgd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0-google-webflux-mongo"
MONGO_DB=workshop_mongo
```

2. Exporte as variáveis de ambiente:

* Para Bash/Zsh:

```bash
export $(grep -v '^#' .env | xargs)
```

* Para Fish shell (use um arquivo auxiliar):
```bash
source load-env.fish
```

3. Execute a aplicação com o perfil `prod:`
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```
**O perfil prod utiliza a URI do MongoDB Atlas definida via variável de ambiente.**

💾 Conectando com MongoDB Compass

🔌 MongoDB local (via Docker)
`mongodb://devuser:devpass@localhost:27018/workshop_mongo?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&ssl=false`

☁️ MongoDB Atlas (online)

Copie a URI fornecida pelo MongoDB Atlas e insira suas credenciais, por exemplo:
`mongodb+srv://usuario:senha@cluster0.lgfdgdfkqhz.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0-google-webflux-mongo`

---

## 🔗 Coleção Postman

Importe a coleção e teste os endpoints com facilidade no Postman:

[📂 Acessar Coleção DSPosts](https://raw.githubusercontent.com/wekers/spring-webflux-mongodb/refs/heads/main/Workshop%20Webflux%20MongoDB.postman_collection.json)

---

## 🛠️ Tecnologias

- Java 17+
- Spring Boot
- Spring Data Reactive MongoDB
- MongoDB
- Postman

