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

- **Backend Framework:** Spring Boot using JDBC-Template
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
   spring.application.name=employee_management
   spring.datasource.url=jdbc:postgresql://localhost:5431/management_db
   spring.datasource.username=habishath
   spring.datasource.password=
   spring.datasource.driver-class-name=org.postgresql.Driver

2. **Dependencies:**
   - Ensure that all required dependencies are listed in the `pom.xml` file.

### Running the Application

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/management-app.git
   cd management-app
    ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

## Endpoints

### Authentication

- **Register**: `POST /api/auth/signup`
  - Request Body: `RegisterRequest`
- **Login**: `POST /api/auth/login`
  - Request Body: `AuthenticationRequest`

### Employee Management

- **ADMIN Endpoints**:
  - **Get Employee by ID**: `GET /api/admin/view/{id}`
  - **Get All Employees**: `GET /api/admin/view`
  - **Save Employee**: `POST /api/admin/add`
  - **Update Employee**: `PUT /api/admin/update/{id}`
  - **Delete Employee**: `DELETE /api/admin/delete/{id}`

- **MANAGER Endpoints**:
  - **Get Employee by ID**: `GET /api/manager/view/{id}`
  - **Get All Employees**: `GET /api/manager/view`
  - **Save Employee**: `POST /api/manager/add`

- **USER Endpoints**:
  - **Get Employee by ID**: `GET /api/user/view/{id}`
  - **Get All Employees**: `GET /api/user/view`

## Contribution

Feel free to contribute by submitting issues or pull requests. Please adhere to the coding standards and write clear commit messages.


## Contact

For questions or feedback, please contact [thavamhabi123@gmail.com]

---
