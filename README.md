# Stock Tracking Application

This project is designed to provide an effective and user-friendly stock tracking solution for warehouses. It is built using Java Spring Boot technology and simplifies stock management operations with its intuitive interface.

## Features

- **Stock Entry and Exit**: Easily add products to and remove products from the warehouse, enabling you to track and manage stock movements effortlessly.
- **View Stock Status**: View the current stock status in detail and monitor stock levels.
- **Export to Excel**: Export stock entries, exits, and current stock status to an Excel file. This feature greatly facilitates reporting and analysis.
- **Role-Based Authorization**: Ensure security with different authorization levels for users and administrators:
  - **User**: Can perform stock entry and exit operations, and manage customer and supplier records.
  - **Admin**: In addition to all User privileges, can access the admin panel via the `/edit` page to edit and delete records.

## Technologies Used

- **Java Spring Boot**: Modern and flexible application framework.
-  **MVC Architecture**: Clean and organized code structure.
- **Hibernate**: Efficient and powerful data access layer.
- **MySQL**: Reliable and high-performance database management system.
-  **Spring Security**: Secure and role-based access control.
- **Export to Excel**: Generate Excel files using Apache POI.

## Screenshots
**Login Page**
![Login Page](/screenshots/login.png)
**Stock Status Page**
![Stock Status Page](/screenshots/stock-status.png)
**Stock In Page**
![Stock In Page](/screenshots/stock-in.png)
**Stock In Adding**
![Stock In Page](/screenshots/stock-in-add.png)
**Stock Out Page**
![Stock Out Page](/screenshots/stock-out.png)
**Customer and Supplier Transactions Page**
![Customer and Supplier Page](/screenshots/customer-supplier.png)
**Admin Panel Page**
![Admin Panel Page](/screenshots/admin-panel.png)
**Excel Export Example**
![Excel Export Example](/screenshots/excel.png)

## Installation Steps

1. **Clone the Project Repository**:
`git clone https://github.com/username/stock-tracking-application.git cd stock-tracking-application`
2. **Configure the Database**: Open `src/main/resources/application.properties` and enter your MySQL database information:
`spring.datasource.url=jdbc:mysql://localhost:3306/stock_tracking`
`spring.datasource.username=root`
`spring.datasource.password=password`
3. **Create the Database**: Use the `stock-tracking.sql` file included in the project files to create your database. Import this file into your MySQL database to set up the necessary tables:
`mysql -u root -p stock_tracking < stock-tracking.sql`
4. **Install Dependencies**: Use Maven to install the required dependencies:
`mvn clean install`
5. **Run the Application**: Start the Spring Boot application:
`mvn spring-boot:run`

## Usage

### Login Information

-   **Admin**:
    -   Username: `admin`
    -   Password: `admin`
-   **User**:
    -   Username: `user`
    -   Password: `user`

### User Roles and Permissions

-   **User**:
    -   Can perform stock entry and exit operations.
    -   Can create customer and supplier records.
-   **Admin**:
    -   In addition to User privileges, can edit and delete records via the `/edit` page.
