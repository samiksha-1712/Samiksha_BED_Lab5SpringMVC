
CREATE DATABASE employee_db;
SHOW DATABASES;
USE employee_db; 

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
    );
SHOW TABLES;
SELECT * FROM employees;



