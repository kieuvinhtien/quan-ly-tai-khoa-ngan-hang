CREATE DATABASE IF NOT EXISTS bankapp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bankapp;

CREATE TABLE IF NOT EXISTS customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    id_number VARCHAR(50),
    phone VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS account (
    account_number VARCHAR(50) PRIMARY KEY,
    customer_id INT NOT NULL,
    balance DOUBLE DEFAULT 0,
    opened_date DATE,
    active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS transaction_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_from VARCHAR(50),   -- có thể null nếu deposit
    account_to VARCHAR(50),     -- có thể null nếu withdraw
    amount DOUBLE NOT NULL,
    type VARCHAR(20) NOT NULL,  -- DEPOSIT, WITHDRAW, TRANSFER
    time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    note VARCHAR(255)
);
