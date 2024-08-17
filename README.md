# 🌟 Employee Management System

## 📝 Overview

The **Employee Management System** is a Spring Boot application designed to manage employee data with varying user roles: **ADMIN**, **MANAGER**, and **USER**. The application features secure JWT-based authentication and role-based access control, providing tailored access and operations for different roles.

## 🚀 Features

- **🔐 Secure Authentication:** User registration and login using JWT.
- **🔑 Role-Based Access Control:**
  - **ADMIN:** Full CRUD operations on employee records.
  - **MANAGER:** Ability to read and create employee records.
  - **USER:** Read-only access to employee data.
- **📋 Employee Management:** Manage employee data efficiently with role-specific permissions.

## 💻 Tech Stack

- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL
- **Security:** Spring Security with JWT
- **Build Tool:** Maven
- **Java Version:** 17

## 🛠️ Setup Instructions

### Prerequisites

- **Java 17**: Ensure you have JDK 17 installed.
- **PostgreSQL**: Install PostgreSQL and create a database.

### Configuration

1. **Database Setup:**
   - Create a PostgreSQL database named `management_db`.
   - Update the `application.properties` file with your PostgreSQL credentials.

2. **Update `application.properties`:**

   ```properties
   spring.application.name=EmployeeManagementApp
   spring.datasource.url=jdbc:postgresql://localhost:5431/management_db
   spring.datasource.username=habishath
   spring.datasource.password=
   spring.datasource.driver-class-name=org.postgresql.Driver
