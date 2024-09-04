# 💰 Bank Client Manager App

A **full-stack** application for managing bank clients, accounts, and transactions. This app allows bank staff to manage client information, view and manage accounts, and perform basic transactions like deposits and withdrawals.

---

## 🛠️ Technologies Used

### Frontend:
- **Angular** - For building a responsive and modern web interface.
- **Angular Material** - For sleek UI components and styling.
  
### Backend:
- **Java (Spring Boot)** - To manage the server-side logic and expose REST APIs.
- **Spring Data JPA** - For easy database interactions with MySQL.
  
### Database:
- **MySQL** - Storing clients, accounts, and transaction data.
- **PHP** - For scripting and database management tasks.

---

## ⚙️ Features

### 🌟 Client Management:
- Add new clients.
- Update existing client information.
- Delete clients.

### 🏦 Account Management:
- View all accounts for a client.
- Add new accounts to clients.
- Check account balances.

### 💵 Transaction Management:
- Perform deposits and withdrawals.
- View transaction history for an account.
- Calculate account balances after transactions.

### 📊 Account Statements:
- View the complete transaction history for each account.

---

## 🎯 Project Setup

### 🖥️ Backend (Spring Boot):
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/bank-client-manager.git
    ```
2. Navigate to the backend directory:
    ```bash
    cd bank-client-manager/backend
    ```
3. Build and run the Spring Boot project:
    ```bash
    mvn spring-boot:run
    ```
4. API Documentation (using Swagger) can be accessed at: `http://localhost:8080/swagger-ui/`.

### 🌐 Frontend (Angular):
1. Install Angular CLI (if not installed):
    ```bash
    npm install -g @angular/cli
    ```
2. Navigate to the frontend directory:
    ```bash
    cd bank-client-manager/frontend
    ```
3. Install dependencies:
    ```bash
    npm install
    ```
4. Run the Angular app:
    ```bash
    ng serve
    ```
5. Open the app at: `http://localhost:4200/`.

### 🗄️ Database (MySQL & PHP):
1. Set up MySQL and create the database by running the `db.php` script.
    - Modify the `db.php` file with your MySQL credentials.
    - Run the script:
    ```bash
    php db.php
    ```

---

## 🚀 Features in Development
- User Authentication (Admin and Bank Staff roles).
- Transaction filters and search functionality.
- Email notifications for important transactions.

---




### ✨ Author

- **Brandon Kureya** - [GitHub Profile](https://github.com/tadiekvx)
