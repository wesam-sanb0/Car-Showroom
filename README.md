# Car Showroom

Desktop Java OOP project built with NetBeans (Swing + JDBC + Apache Derby).

Car Showroom is a desktop Java OOP app built with NetBeans and Swing. It supports signup/login, car browsing and management, purchase orders, test-drive booking, and invoice text generation. Data is stored in Apache Derby via JDBC, with separate role-based interfaces for customers and employees.

## Open In NetBeans

1. Open NetBeans.
2. Choose File -> Open Project.
3. Select this folder.
4. Build and run the project.

## Database Setup (Derby)

1. Start Apache Derby (localhost:1527).
2. Create database: `ShowroomPlatForm`.
3. Create user: `oopproject` with password `oopproject`.
4. Run SQL script: `DatabaseProject/DatabaseProject.sql`.

The app connection values are in `src/oop/project/personalQuery.java`.

## What Is Included

- Source code: `src/`
- NetBeans config: `nbproject/` (except private settings)
- Build script: `build.xml`
- Database script: `DatabaseProject/DatabaseProject.sql`

## Not Included In Git

- `build/` compiled output
- `nbproject/private/` machine-specific NetBeans settings
