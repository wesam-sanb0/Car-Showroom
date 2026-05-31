# Car Showroom

Desktop Java OOP project built with NetBeans, Swing, JDBC, and Apache Derby.

## Group Members

- Wesam Sanbo
- Shoaaa Essam Alkhutani
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

```
oop project 77/
	oop project 5/
		build.xml
		manifest.mf
		README.md
		DatabaseProject/
			DatabaseProject.sql
		nbproject/
			build-impl.xml
			genfiles.properties
			project.properties
			project.xml
		src/
			images/
			oop/
				project/
					*.java
					*.form
		PurchaseInvoices/
		TestDriveInvoices/
```

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
