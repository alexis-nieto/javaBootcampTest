
# Project Requeriments

<!-- wyattrafaelhh@hotmail.com -->

<!--

## **Caso práctico: Sistema de Gestión de Biblioteca**

### Gestión de libros
- Añadir nuevos libros.
- Eliminar libros existentes.
- Actualizar información de libros. 
- Buscar libros por diferentes criterios (título, autor, ISBN).

### Gestión de miembros
- Registrar nuevos miembros.
- Eliminar miembros existentes.
- Actualizar información de miembros.
- Buscar miembros por diferentes criterios (nombre, ID de miembro).

### Transacciones de préstamo
- Registrar un préstamo de libro.
- Registrar la devolución de un libro. 
- Ver historial de préstamos de un miembro.
- Ver disponibilidad de un libro.
 
### Requerimientos no funcionales  
- Interfaz de Usuario: Consola simple para interacciones del usuario.
- Persistencia: Utilizar una base de datos MySQL para almacenar datos de libros, miembros y transacciones.
- Manejo de Excepciones: Manejar adecuadamente todas las posibles excepciones que puedan surgir durante las operaciones del sistema.
- Documentación: Código bien documentado, instrucciones claras sobre cómo configurar y ejecutar el sistema.
 
### Consejos y buenas prácticas

- Validación de Datos:
Asegúrate de validar todos los datos de entrada para evitar errores y problemas de seguridad.

- Manejo de Excepciones:
Maneja todas las excepciones posibles de manera adecuada para evitar que la aplicación falle inesperadamente.

- Modularidad:
Mantén el código modular y organizado en paquetes lógicos para facilitar el mantenimiento y la escalabilidad del sistema.

- Documentación:
Documenta el código y proporciona instrucciones claras sobre cómo configurar y ejecutar la aplicación.

- Pruebas:
Realiza pruebas exhaustivas de todas las funcionalidades para asegurarte de que el sistema funciona correctamente en todos los escenarios posibles.

-->

## **Practical Case: Library Management System**

### Book Management

- Add new books.
- Remove existing books.
- Update book information.
- Search for books by different criteria (title, author, ISBN).

### Member Management

- Register new members.
- Remove existing members.
- Update member information.
- Search for members by different criteria (name, member ID).

### Loan Transactions

- Register a book loan.
- Register the return of a book.
- View a member's loan history.
- Check the availability of a book.

### Non-functional Requirements

- User Interface: Simple console for user interactions.
- Persistence: Use a MySQL database to store data about books, members, and transactions.
- Exception Handling: Properly handle all possible exceptions that may arise during system operations.
- Documentation: Well-documented code, clear instructions on how to set up and run the system.

### Tips and Best Practices

- Data Validation:
  - Ensure to validate all input data to avoid errors and security issues.

- Exception Handling:
  - Handle all possible exceptions appropriately to prevent the application from failing unexpectedly.

- Modularity:
  - Keep the code modular and organized into logical packages to facilitate system maintenance and scalability.

- Documentation:
  - Document the code and provide clear instructions on how to set up and run the application.

- Testing:
  - Perform thorough testing of all functionalities to ensure that the system works correctly in all possible scenarios.

# Maven

## Dependencies 

| Dependency | Usage |
|-|-|
| [JUnit Jupiter API » 5.11.0-M2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.0-M2) | Unit testing. |
| [MySQL Connector/J » 9.0.0](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.0.0) | Connection to MySQL database. |
| [JSON.simple » 1.1.1](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1) | JSON handling for settings file. |

# Databases

## Configuration file

The library management system’s settings are stored in a JSON file. This file contains essential details for database connections, including the host, port, username, and password. The format is as follows:

```json
{
  "database_url": "jdbc:mysql://localhost:3306/",
  "database_name": "library", 
  "username": "root",
  "password": "SecretPassword123!@#"
}
```

To run the application, ensure that the file is stored locally at the following path:

```powershell
"%LOCALAPPDATA%\lms\config.json"
```

For example:

```powershell
"C:\Users\%USER%\AppData\Local\lms\config.json"
```

Google's 'JSON.simple' library (version 1.1.1) manages the handling of this JSON format.

Additionally, a demo file is available within the project directory at /demo/config.json.

### Credentials retrieval.

The static method `getConfig("key");` from the abstract class Config needs to be used to get a String with the requided configuration value from the JSON file. This method should handle any exceptions that may occur during the file reading or parsing process. For example:

```java
String example = Config.getConfig("database_url");
```

Available keys:
- `database_url`: Database URL.
- `database_name`: Database name.
- `username`: Database username.
- `password`: Database password.


## MySQL Database

The `library` database is designed to manage the operations of a public library system. It consists of three main tables: `books`, `members`, and `loans`. This document provides a detailed explanation of each table and its columns.

### Database Creation
The `library` database is created using the following SQL statement:

```sql
CREATE DATABASE library;
```

After creating the database, the `USE` statement is used to switch the context to the `library` database:


```sql
USE library;
```

### Table: `books`

The books table stores information about the books available in the library.

| Column Name | Data Type | Constraints | Description |
|-------------|-----------|-------------|-------------|
| isbn | VARCHAR(13) | PRIMARY KEY | The unique ISBN (International Standard Book Number) of the book. |
| title | VARCHAR(255) | NOT NULL | The title of the book. |
| author | VARCHAR(255) | NOT NULL | The author of the book. |
| publisher | VARCHAR(255) | NOT NULL | The publisher of the book. |
| publication_year | INT | NOT NULL | The year of publication of the book. |
| page_count | INT | NOT NULL | The number of pages in the book. |
| stock_quantity | INT | NOT NULL, DEFAULT 0 | The quantity of the book in stock. |
| genre | VARCHAR(100) | | The genre or category of the book. |
| language_db | VARCHAR(50) | | The language in which the book is written. |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP | The timestamp indicating when the book record was created. |
| updated_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | The timestamp indicating when the book record was last updated. |

### Table: `members`

The members table stores information about the library members.

| Column Name | Data Type | Constraints | Description |
|-------------|-----------|-------------|-------------|
| member_id | INT | AUTO_INCREMENT, PRIMARY KEY | The unique identifier for each library member. |
| first_name | VARCHAR(50) | NOT NULL | The first name of the member. |
| last_name | VARCHAR(50) | NOT NULL | The last name of the member. |
| phone_number | VARCHAR(20) | | The phone number of the member. |
| email | VARCHAR(255) | NOT NULL, UNIQUE | The email address of the member. |
| address_db | VARCHAR(255) | | The address of the member. |
| city | VARCHAR(100) | | The city where the member resides. |
| state_db | VARCHAR(100) | | The state where the member resides. |
| zip_code | VARCHAR(20) | | The zip code of the member's address. |
| membership_start_date | DATE | NOT NULL | The date when the member's membership starts. |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP | The timestamp indicating when the member record was created. |
| updated_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | The timestamp indicating when the member record was last updated. |

### Table: `loans`

The loans table stores information about the book loans made by library members.

| Column Name | Data Type | Constraints | Description |
|-------------|-----------|-------------|-------------|
| loan_id | INT | AUTO_INCREMENT, PRIMARY KEY | The unique identifier for each loan. |
| member_id | INT | NOT NULL, FOREIGN KEY (members.member_id) | The identifier of the member who borrowed the book. |
| isbn | VARCHAR(13) | NOT NULL, FOREIGN KEY (books.isbn) | The ISBN of the borrowed book. |
| loan_date | DATE | NOT NULL | The date when the book was borrowed. |
| return_due_date | DATE | NOT NULL | The date by which the book should be returned. |
| actual_return_date | DATE | | The actual date when the book was returned (can be NULL if not yet returned). |
| status_db | ENUM | NOT NULL, DEFAULT 'active', ('active', 'returned') | The status of the loan ('active' or 'returned'). |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP | The timestamp indicating when the loan record was created. |
| updated_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | The timestamp indicating when the loan record was last updated. |

You can create these tables by running:

```sql
-- Create the 'books' table
CREATE TABLE books (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    publication_year INT NOT NULL,
    page_count INT NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    genre VARCHAR(100),
    language_db VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the 'members' table
CREATE TABLE members (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(255) NOT NULL UNIQUE,
    address_db VARCHAR(255),
    city VARCHAR(100),
    state_db VARCHAR(100),
    zip_code VARCHAR(20),
    membership_start_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the 'loans' table
CREATE TABLE loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    loan_date DATE NOT NULL,
    return_due_date DATE NOT NULL,
    actual_return_date DATE,
    status_db ENUM('active', 'returned') NOT NULL DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

And you can add some filler examples by running:

```sql
-- Insert sample data into the 'books' table
INSERT INTO books (isbn, title, author, publisher, publication_year, page_count, stock_quantity, genre, language_db)
VALUES
    ('9780593311257', 'The Midnight Library', 'Matt Haig', 'Viking', 2020, 304, 15, 'Magical Realism', 'English'),
    ('9780525559474', 'The Vanishing Half', 'Brit Bennett', 'Riverhead Books', 2020, 352, 12, 'Historical Fiction', 'English'),
    ('9780593311295', 'The Invisible Life of Addie LaRue', 'V.E. Schwab', 'Tor Books', 2020, 448, 10, 'Fantasy', 'English'),
    ('9780593190517', 'The Overstory', 'Richard Powers', 'W. W. Norton & Company', 2018, 512, 8, 'Environmental Fiction', 'English'),
    ('9780593311233', 'The Nickel Boys', 'Colson Whitehead', 'Doubleday', 2019, 224, 6, 'Historical Fiction', 'English'),
    ('9780593230251', 'The Anthropocene Reviewed', 'John Green', 'Dutton', 2021, 304, 14, 'Essays', 'English'),
    ('9780593311219', 'The Midnight Bargain', 'C.L. Polk', 'Erewhon', 2020, 384, 9, 'Fantasy', 'English'),
    ('9780593087497', 'The Prophets', 'Robert Jones Jr.', 'G.P. Putnam''s Sons', 2021, 400, 11, 'Historical Fiction', 'English');

-- Insert sample data into the 'members' table
INSERT INTO members (first_name, last_name, phone_number, email, address_db, city, state_db, zip_code, membership_start_date)
VALUES
    ('Liam', 'Nguyen', '5551234567', 'liam.nguyen@example.com', '1234 Maple Ave', 'Seattle', 'WA', '98101', '2021-01-15'),
    ('Emma', 'Garcia', '5559876543', 'emma.garcia@example.com', '5678 Oak St', 'Denver', 'CO', '80202', '2021-03-20'),
    ('Noah', 'Patel', '5554561234', 'noah.patel@example.com', '9101 Pine Rd', 'Atlanta', 'GA', '30303', '2021-05-10'),
    ('Ava', 'Kim', '5557894561', 'ava.kim@example.com', '1213 Cedar Ln', 'Miami', 'FL', '33101', '2021-07-05'),
    ('William', 'Chen', '5552345678', 'william.chen@example.com', '1415 Birch St', 'Boston', 'MA', '02101', '2021-09-12'),
    ('Sophia', 'Hernandez', '5556789012', 'sophia.hernandez@example.com', '1617 Walnut Ave', 'Dallas', 'TX', '75201', '2021-11-08'),
    ('James', 'Wong', '5553456789', 'james.wong@example.com', '1819 Spruce Rd', 'San Francisco', 'CA', '94101', '2022-01-18'),
    ('Mia', 'Tran', '5557890123', 'mia.tran@example.com', '2021 Elm Ln', 'Washington', 'DC', '20001', '2022-03-22'),
    ('Oliver', 'Lee', '5551234568', 'oliver.lee@example.com', '2223 Maple Ave', 'Seattle', 'WA', '98101', '2022-05-15'),
    ('Charlotte', 'Gonzalez', '5559876544', 'charlotte.gonzalez@example.com', '2425 Oak St', 'Denver', 'CO', '80202', '2022-07-20'),
    ('Elijah', 'Singh', '5554561235', 'elijah.singh@example.com', '2627 Pine Rd', 'Atlanta', 'GA', '30303', '2022-09-10'),
    ('Amelia', 'Park', '5557894562', 'amelia.park@example.com', '2829 Cedar Ln', 'Miami', 'FL', '33101', '2022-11-05'),
    ('Benjamin', 'Liu', '5552345679', 'benjamin.liu@example.com', '3031 Birch St', 'Boston', 'MA', '02101', '2023-01-12'),
    ('Isabella', 'Martinez', '5556789013', 'isabella.martinez@example.com', '3233 Walnut Ave', 'Dallas', 'TX', '75201', '2023-03-08'),
    ('Lucas', 'Choi', '5553456790', 'lucas.choi@example.com', '3435 Spruce Rd', 'San Francisco', 'CA', '94101', '2023-05-18'),
    ('Harper', 'Vu', '5557890124', 'harper.vu@example.com', '3637 Elm Ln', 'Washington', 'DC', '20001', '2023-07-22');

-- Insert sample data into the 'loans' table
INSERT INTO loans (member_id, isbn, loan_date, return_due_date)
VALUES
    (1, '9780593311257', '2024-01-01', '2024-01-15'),
    (2, '9780525559474', '2024-01-05', '2024-01-19'),
    (1, '9780593311295', '2024-01-10', '2024-01-24'),
    (3, '9780593190517', '2024-01-12', '2024-01-26'),
    (4, '9780593311233', '2024-01-15', '2024-01-29'),
    (5, '9780593311226', '2024-01-18', '2024-02-01'),
    (6, '9780593087503', '2024-01-20', '2024-02-03'),
    (7, '9780593311271', '2024-01-22', '2024-02-05'),
    (8, '9780525559481', '2024-01-25', '2024-02-08'),
    (9, '9780593311257', '2024-01-28', '2024-02-11'),
    (10, '9780525559474', '2024-01-30', '2024-02-13');
```


### Timestamps
The `created_at` and `updated_at` columns in each table are used to track the creation and modification timestamps of records. These columns are automatically populated and updated by the database system.

- `created_at`
Stores the timestamp when a record is inserted into the table.

- `updated_at`
Stores the timestamp when a record is updated in the table.

These timestamps can be useful for auditing, tracking changes, and determining the age or freshness of records.


# Testing

Due to time constrains, some basic JUnit testing was done for the DB Drivers only.

The test class is located on `/src/test/java/com/jbt/db/drivers/DriversTest.java`.

The version of was: [JUnit Jupiter API » 5.11.0-M2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.11.0-M2)