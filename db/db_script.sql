-- Database: bank_manager_db

CREATE DATABASE IF NOT EXISTS bank_manager_db;
USE bank_manager_db;

-- Table: clients
CREATE TABLE IF NOT EXISTS clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Table: accounts
CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(50) NOT NULL UNIQUE,
    balance DECIMAL(15, 2) NOT NULL DEFAULT 0,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);

-- Table: transactions
CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT,
    type ENUM('deposit', 'withdrawal') NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);
