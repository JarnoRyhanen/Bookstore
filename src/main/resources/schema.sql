
CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS category (
    category_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE IF NOT EXISTS book (
    book_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) DEFAULT NULL,
    author VARCHAR(50) DEFAULT NULL,
    isbn VARCHAR(13) DEFAULT NULL,
    publication_year INT DEFAULT NULL,
    price DECIMAL(4,2) DEFAULT NULL,
    category_id INT,
    PRIMARY KEY (book_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);