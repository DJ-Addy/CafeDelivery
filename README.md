# Cafe Food Delivery Website

A full-stack web application for cafe food delivery, built using **Spring Boot** for backend APIs, **React** for frontend UI, and **SQL** for data management. The application provides modules for both **Admin** and **Supplier** roles to manage inventory, orders, and customer interactions effectively.

![Cafe Database schema](https://github.com/user-attachments/assets/10efe082-07c5-41f7-a27a-ae31d6b9820d)


## Features
- **Customer Module**: Browse food items, place orders, track delivery, and view order history.
- **Admin Module**: Manage orders, customers, and menu items with full control over the application's content.
- **Supplier Module**: Handle food inventory and ensure stock availability for smooth operations.
- **Food Item Customization**: Easily add images, descriptions, prices, and availability statuses for food items.
- **Secure Authentication**: Role-based access for customers, admins, and suppliers.
- **Responsive Design**: Optimized for both desktop and mobile experiences.

## Technology Stack
- **Backend**: Java, Spring Boot
- **Frontend**: React, JavaScript, HTML, CSS
- **Database**: SQL (MySQL/PostgreSQL)
- **APIs**: RESTful API design
- **Storage**: Cloud storage (for food images and media assets)

## Installation

### Prerequisites
- **Java** 11+
- **Node.js** 14+
- **MySQL/PostgreSQL**

### Backend (Spring Boot)
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/food-delivery.git
    cd food-delivery/backend
    ```

2. Update the `application.properties` with your database configurations.

3. Run the backend:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend (React)
1. Navigate to the frontend folder:
    ```bash
    cd ../frontend
    ```

2. Install dependencies:
    ```bash
    npm install
    ```

3. Start the frontend server:
    ```bash
    npm start
    ```

## Usage
1. Visit `http://localhost:3000` to access the frontend interface.
2. Admins and suppliers can log in with their credentials for additional management features.

## Project Screenshots

### Homepage
![HomePage](https://github.com/user-attachments/assets/b881901f-c3ff-49cb-8525-2de5e9c88ecc)

### Menu
![Screenshot 2024-10-26 151307](https://github.com/user-attachments/assets/9555823e-f65c-4384-93a8-9863a2c69ee1)

## API Endpoints

- **`/api/orders`** - Order management endpoint.
- **`/api/foods`** - Manage food items and images.
- **`/api/users`** - User authentication and role management.

## Contributing
1. Fork this repository
2. Create a new branch
3. Make changes and commit
4. Submit a pull request for review

## License
[MIT License](LICENSE)
