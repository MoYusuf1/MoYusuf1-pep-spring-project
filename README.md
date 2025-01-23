# Project: Spring Social Media Blog API

## Overview

This project is a backend API for a hypothetical social media application. It allows users to manage accounts and messages in a micro-blogging environment. Built with the Spring Boot Framework, this application supports core functionalities such as user registration, login, and CRUD operations for messages. The project leverages Spring Boot’s dependency injection, JPA for data persistence, and MVC architecture for structured endpoint handling. All features are functional, meeting requirements for account and message management. Future enhancements include adding JWT authentication, pagination, and advanced error handling.

## Features

- User Registration: POST /register - Create an account with unique username and password (≥ 4 characters).
- Login: POST /login - Authenticate using username and password.
- Post Message: POST /messages - Submit messages (≤ 255 characters).
- View Messages: GET /messages - Retrieve all messages or by ID (/messages/{id}).
- User Messages: GET /accounts/{id}/messages - View messages from a specific user.
- Update/Delete Messages: PATCH /messages/{id}, DELETE /messages/{id} - Modify or remove posts.

## Tech Stack

- Framework: Spring Boot with JPARepositories and MVC structure.
- Database: Tables for Account (user data) and Message (posts).
- Validation: Ensures valid inputs using Spring annotations.
- Dependency Injection: Enables modular and scalable code.

