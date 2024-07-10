-- Create the 'library' database
CREATE DATABASE library;

-- Use the 'library' database
USE library;

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
    ('9780593087497', 'The Prophets', 'Robert Jones Jr.', 'G.P. Putnam''s Sons', 2021, 400, 11, 'Historical Fiction', 'English'),
    ('9780593311264', 'The Invisible Life of Addie LaRue', 'V.E. Schwab', 'Tor Books', 2020, 448, 10, 'Fantasy', 'English'),
    ('9780593190524', 'The Overstory', 'Richard Powers', 'W. W. Norton & Company', 2018, 512, 8, 'Environmental Fiction', 'English'),
    ('9780593311240', 'The Nickel Boys', 'Colson Whitehead', 'Doubleday', 2019, 224, 6, 'Historical Fiction', 'English'),
    ('9780593230268', 'The Anthropocene Reviewed', 'John Green', 'Dutton', 2021, 304, 14, 'Essays', 'English'),
    ('9780593311226', 'The Midnight Bargain', 'C.L. Polk', 'Erewhon', 2020, 384, 9, 'Fantasy', 'English'),
    ('9780593087503', 'The Prophets', 'Robert Jones Jr.', 'G.P. Putnam''s Sons', 2021, 400, 11, 'Historical Fiction', 'English'),
    ('9780593311271', 'The Midnight Library', 'Matt Haig', 'Viking', 2020, 304, 15, 'Magical Realism', 'English'),
    ('9780525559481', 'The Vanishing Half', 'Brit Bennett', 'Riverhead Books', 2020, 352, 12, 'Historical Fiction', 'English');

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