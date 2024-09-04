<?php
// Database connection configuration
$host = 'localhost';
$db = 'bank_manager_db';
$user = 'root';  // Replace with your MySQL username
$pass = '';      // Replace with your MySQL password

// Create connection
$conn = new mysqli($host, $user, $pass);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Create the database
$sql = "CREATE DATABASE IF NOT EXISTS $db";
if ($conn->query($sql) === TRUE) {
    echo "Database created successfully\n";
} else {
    echo "Error creating database: " . $conn->error;
}

// Select the database
$conn->select_db($db);

// SQL queries to create tables
$queries = [
    // Clients table
    "CREATE TABLE IF NOT EXISTS clients (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL
    )",
    
    // Accounts table
    "CREATE TABLE IF NOT EXISTS accounts (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        account_number VARCHAR(50) NOT NULL UNIQUE,
        balance DECIMAL(15, 2) NOT NULL DEFAULT 0,
        client_id BIGINT,
        FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
    )",
    
    // Transactions table
    "CREATE TABLE IF NOT EXISTS transactions (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        account_id BIGINT,
        type ENUM('deposit', 'withdrawal') NOT NULL,
        amount DECIMAL(15, 2) NOT NULL,
        date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
    )"
];

// Execute each query
foreach ($queries as $query) {
    if ($conn->query($query) === TRUE) {
        echo "Table created successfully\n";
    } else {
        echo "Error creating table: " . $conn->error;
    }
}

// Close connection
$conn->close();
?>
