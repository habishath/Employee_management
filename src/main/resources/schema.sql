CREATE DATABASE management_db;

USE management_db;

CREATE TABLE app_user (
                          user_id SERIAL PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50),
                          email VARCHAR(50) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          role VARCHAR(50) NOT NULL
);


CREATE TABLE employee (
                          employee_id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(50) UNIQUE NOT NULL,
                          position VARCHAR(50)
);
