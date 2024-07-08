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
    language VARCHAR(50),
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
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip_code VARCHAR(20),
    membership_start_date DATE NOT NULL,
    membership_end_date DATE,
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
    status ENUM('active', 'returned') NOT NULL DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample data into the 'books' table
INSERT INTO books (isbn, title, author, publisher, publication_year, page_count, stock_quantity, genre, language)
VALUES
    ('9780141036144', '1984', 'George Orwell', 'Penguin Books', 1949, 328, 10, 'Dystopian Fiction', 'English'),
    ('9780060935467', 'To Kill a Mockingbird', 'Harper Lee', 'Harper Perennial', 1960, 336, 5, 'Classic Literature', 'English'),
    ('9780743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1925, 180, 8, 'Classic Literature', 'English'),
    ('9780307474278', 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', 1951, 224, 6, 'Classic Literature', 'English'),
    ('9780061120084', 'One Hundred Years of Solitude', 'Gabriel García Márquez', 'Harper Perennial', 1967, 417, 3, 'Magical Realism', 'Spanish'),
    ('9780451524935', 'Animal Farm', 'George Orwell', 'Signet Classics', 1945, 140, 12, 'Political Satire', 'English'),
    ('9780679720201', 'The Stranger', 'Albert Camus', 'Vintage', 1942, 123, 7, 'Existentialism', 'French'),
    ('9780143105428', 'Pride and Prejudice', 'Jane Austen', 'Penguin Classics', 1813, 480, 9, 'Romance', 'English');

-- Insert sample data into the 'members' table
INSERT INTO members (first_name, last_name, phone_number, email, address, city, state, zip_code, membership_start_date)
VALUES
    ('John', 'Doe', '1234567890', 'john.doe@example.com', '123 Main St', 'New York', 'NY', '10001', '2022-01-01'),
    ('Jane', 'Smith', '9876543210', 'jane.smith@example.com', '456 Elm St', 'Los Angeles', 'CA', '90001', '2022-02-15'),
    ('Michael', 'Johnson', '5555555555', 'michael.johnson@example.com', '789 Oak Ave', 'Chicago', 'IL', '60601', '2022-03-10'),
    ('Emily', 'Davis', '1112223333', 'emily.davis@example.com', '321 Pine Rd', 'Houston', 'TX', '77001', '2022-04-20'),
    ('David', 'Wilson', '4445556666', 'david.wilson@example.com', '654 Maple Dr', 'Philadelphia', 'PA', '19019', '2022-05-05'),
    ('Sarah', 'Anderson', '7778889999', 'sarah.anderson@example.com', '987 Cedar Ln', 'Phoenix', 'AZ', '85001', '2022-06-12'),
    ('Robert', 'Taylor', '2223334444', 'robert.taylor@example.com', '741 Birch St', 'San Antonio', 'TX', '78201', '2022-07-08'),
    ('Jennifer', 'Martinez', '5556667777', 'jennifer.martinez@example.com', '852 Walnut Ave', 'San Diego', 'CA', '92101', '2022-08-18');

-- Insert sample data into the 'loans' table
INSERT INTO loans (member_id, isbn, loan_date, return_due_date)
VALUES
    (1, '9780141036144', '2023-05-01', '2023-05-15'),
    (2, '9780060935467', '2023-05-05', '2023-05-19'),
    (1, '9780743273565', '2023-05-10', '2023-05-24'),
    (3, '9780307474278', '2023-05-12', '2023-05-26'),
    (4, '9780061120084', '2023-05-15', '2023-05-29'),
    (5, '9780451524935', '2023-05-18', '2023-06-01'),
    (2, '9780679720201', '2023-05-20', '2023-06-03'),
    (1, '9780143105428', '2023-05-22', '2023-06-05');

SELECT * FROM books;