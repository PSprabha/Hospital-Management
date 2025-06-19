# CarePlus Patient Management System

## Overview
CarePlus is a Java-based Patient Management System designed for clinics and hospitals. It provides functionalities for administrators, receptionists, and doctors to manage patient records, appointments, and staff efficiently.

## Features
- **Admin and Receptionist Login:**
  - Secure login system for administrators and receptionists, ensuring only authorized personnel can access sensitive patient and hospital data.
- **Patient Registration and Management:**
  - Register new patients, update their details, and maintain a comprehensive record of patient information, including contact details, age, and other relevant data.
- **Doctor Management:**
  - Add, update, and view doctor profiles, including their specialization, contact information, and available slots for appointments.
- **Appointment Scheduling and Management:**
  - Schedule appointments between patients and doctors, check slot availability, and manage appointment records efficiently.
- **Role-Based Access:**
  - Different functionalities and access levels for admins and receptionists, ensuring data privacy and operational efficiency.
- **MySQL Database Integration:**
  - All data is securely stored and managed using a MySQL database, providing reliability and scalability for clinical operations.

## Project Structure
```
Main.java                // Entry point of the application
features/                // Contains feature modules for admin, receptionist, and registration
  admin/                 // Admin-related views and models
  receptionist/          // Receptionist-related views and models
  registration/          // Handles user login and registration logic
repository/              // Data access and transfer objects
  db/                    // Database connection and DAO classes
  dto/                   // Data Transfer Object (DTO) classes for entities
utils/                   // Utility classes and helper functions
```

## Prerequisites
- Java 8 or above
- MySQL Server
- MySQL JDBC Driver (Connector/J)

## Database Setup
1. Create a MySQL database named `careplus`.
2. Create the required tables for admins, receptionists, doctors, patients, and appointments. (Refer to the code for table structure or use your own schema as needed.)
3. Update the database credentials in `repository/db/DbConnection.java`:
   ```java
   private static final String USER = "<your_mysql_username>";
   private static final String PASSWORD = "<your_mysql_password>";
   ```

## How to Run
1. Compile the project:
   ```sh
   javac -d . Main.java
   ```
2. Run the application:
   ```sh
   java com.zsgs.careplus.Main
   ```

## Default Credentials
- **Admin**
  - Username: `admin`
  - Password: `admin123`
- **Receptionist**
  - Username: `reception`
  - Password: `reception123`

## Notes
- Ensure MySQL server is running before starting the application.
- The application will auto-create default admin and receptionist accounts if they do not exist.
- For any issues, check the console output for error messages.

## License
This project is for educational purposes. 