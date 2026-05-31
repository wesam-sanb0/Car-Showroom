# Car Showroom

Desktop Java OOP project built with NetBeans, Swing, JDBC, and Apache Derby.

## Group Members

- Shoaaa Essam Alkhutani
- Wesam Kamal Sanbo
- Bushra Ishaq
- Layan Nawaf Al-Rowaily
- Amal Saad Alghamdi
- Shaima Ziad Al-abdulhadi

## What Car Showroom Does

- Supports signup and login for customers and employees.
- Allows browsing cars and viewing car details.
- Lets employees add and manage car records.
- Handles purchase orders and test-drive booking.
- Generates invoice text files for orders and test drives.
- Uses role-based interfaces for customer and employee workflows.

## Tech Stack

- Java
- Java Swing (desktop GUI)
- JDBC
- Apache Derby
- NetBeans (Ant project)

## Project Structure

- src/: Java source files and Swing forms
- nbproject/: NetBeans project configuration
- DatabaseProject/DatabaseProject.sql: Database schema and setup script
- PurchaseInvoices/: Generated purchase invoice files
- TestDriveInvoices/: Generated test-drive invoice files
- build.xml: Ant build script
- manifest.mf: JAR manifest

## Quick Start

1. Open NetBeans.
2. Choose File -> Open Project.
3. Select the Car Showroom project folder.
4. Start Apache Derby on localhost:1527.
5. Create database ShowroomPlatForm.
6. Create user oopproject with password oopproject.
7. Run DatabaseProject/DatabaseProject.sql.
8. Build and run the project in NetBeans.

Database connection values are configured in src/oop/project/personalQuery.java.

## Notes

- The build/ directory is generated output and should not be committed.
- nbproject/private/ contains machine-specific settings.
