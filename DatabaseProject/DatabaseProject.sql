-- Create the database
CREATE DATABASE IF NOT EXISTS ShowroomPlatForm;
USE ShowroomPlatForm;

-- Create ShowroomManager table
CREATE TABLE ShowroomManager (
    ManagerID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    MiddleName VARCHAR(50),
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(15),
    EmployeeID INT UNIQUE
);

-- Create Employee table
CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    MiddleName VARCHAR(50),
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(15),
    Role VARCHAR(50) NOT NULL,
    ManagerID INT,
    FOREIGN KEY (ManagerID) REFERENCES ShowroomManager(ManagerID)
);

-- Create Car table
CREATE TABLE Car (
    CarID INT PRIMARY KEY,
    ManagerID INT,
    Make VARCHAR(50) NOT NULL,
    Model VARCHAR(50) NOT NULL,
    Year INT NOT NULL CHECK (Year >= 1900),
    Price DECIMAL(10,2) NOT NULL CHECK (Price >= 0),
    Type VARCHAR(50),
    Features TEXT,
    FOREIGN KEY (ManagerID) REFERENCES ShowroomManager(ManagerID)
);

-- Create Customer table
CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    MiddleName VARCHAR(50),
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Phone VARCHAR(15),
    Street VARCHAR(255),
    City VARCHAR(50),
    State VARCHAR(50),
    ZipCode VARCHAR(10)
);

-- Create OrderTable
CREATE TABLE OrderTable (
    OrderID INT PRIMARY KEY,
    CustomerID INT NOT NULL,
    CarID INT NOT NULL,
    OrderDate DATE NOT NULL,
    Status VARCHAR(50) NOT NULL,
    TotalPrice DECIMAL(10,2) NOT NULL CHECK (TotalPrice >= 0),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (CarID) REFERENCES Car(CarID)
);

-- Create TestDrive table
CREATE TABLE TestDrive (
    TestDriveID INT PRIMARY KEY,
    CustomerID INT NOT NULL,
    CarID INT NOT NULL,
    EmployeeID INT NOT NULL,
    Date DATE NOT NULL,
    Time TIME NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (CarID) REFERENCES Car(CarID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

-- Create OrderEmployeeWorksOn table
CREATE TABLE OrderEmployeeWorksOn (
    OrderID INT,
    EmployeeID INT,
    PRIMARY KEY (OrderID, EmployeeID),
    FOREIGN KEY (OrderID) REFERENCES OrderTable(OrderID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

-- Create CustomerTestDrives table
CREATE TABLE CustomerTestDrives (
    CustomerID INT PRIMARY KEY,
    TestDriveCount INT NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Insert data into ShowroomManager
INSERT INTO ShowroomManager (ManagerID, FirstName, MiddleName, LastName, Email, Phone)
VALUES
(1, 'Fahad', 'Ahmed', 'Al-Qahtani', 'fahad.alqahtani@email.com', '920-345-6789'),
(2, 'Noura', 'Mohammed', 'Al-Fayez', 'noura.alfayez@email.com', '921-456-7890');

-- Insert data into Employee
INSERT INTO Employee (EmployeeID, FirstName, MiddleName, LastName, Email, Phone, Role, ManagerID)
VALUES
(1, 'Omar', 'Rakan', 'Al-Mutairi', 'omar.almutairi@email.com', '930-123-4567', 'Sales Representative', 1),
(2, 'Hana', 'Saad', 'Al-Dosari', 'hana.aldosari@email.com', '931-234-5678', 'Customer Support', 1),
(3, 'Salem', 'Thamer', 'Al-Otaibi', 'salem.alotaibi@email.com', '932-345-6789', 'Finance Specialist', 2),
(4, 'Aisha', 'Amer', 'Al-Rashid', 'aisha.alrashid@email.com', '933-456-7890', 'Marketing Coordinator', 2),
(5, 'Khaled', 'Fahd', 'Al-Zahrani', 'khaled.zahrani@email.com', '934-567-8901', 'Sales Representative', 2);

-- Update ShowroomManager to link to employees
UPDATE ShowroomManager SET EmployeeID = 1 WHERE ManagerID = 1;
UPDATE ShowroomManager SET EmployeeID = 3 WHERE ManagerID = 2;

-- Insert data into Car
INSERT INTO Car (CarID, ManagerID, Make, Model, Year, Price, Type, Features)
VALUES
(1, 1, 'Toyota', 'Camry', 2023, 30000.00, 'Sedan', 'Bluetooth, Backup Camera'),
(2, 1, 'Honda', 'Accord', 2023, 28000.00, 'Sedan', 'Sunroof, Heated Seats'),
(3, 2, 'Ford', 'Explorer', 2022, 35000.00, 'SUV', 'All-wheel Drive, Navigation'),
(4, 2, 'Tesla', 'Model 3', 2024, 42000.00, 'Electric', 'Autopilot, Glass Roof'),
(5, 1, 'Chevrolet', 'Tahoe', 2021, 39000.00, 'SUV', 'Leather Seats, Parking Sensors');

-- Insert data into Customer
INSERT INTO Customer (CustomerID, FirstName, MiddleName, LastName, Email, Phone, Street, City, State, ZipCode)
VALUES
(1, 'Layan', 'Nawaf', 'Al-Rowaily', 'layan.na@email.com', '123-456-7890', '123 Main St', 'New York', 'NY', '10001'),
(2, 'Shoaaa', 'Essam', 'Alkhutani', 'shoaa.e@email.com', '234-567-8901', '456 Oak St', 'Los Angeles', 'CA', '90001'),
(3, 'Khalid', 'Saad', 'Al-Harbi', 'khalid.alharbi@email.com', '922-678-3456', '789 Pine St', 'Chicago', 'IL', '60601'),
(4, 'Alice', 'M.', 'Davis', 'alice.davis@email.com', '678-901-2345', '321 Maple Ave', 'Dallas', 'TX', '75201'),
(5, 'Bob', 'N.', 'Wilson', 'bob.wilson@email.com', '789-012-3456', '654 Cedar Rd', 'Phoenix', 'AZ', '85001');

-- Insert data into OrderTable
INSERT INTO OrderTable (OrderID, CustomerID, CarID, OrderDate, Status, TotalPrice)
VALUES
(1, 1, 1, '2024-03-20', 'Completed', 30000.00),
(2, 2, 2, '2024-03-22', 'Pending', 28000.00),
(3, 3, 3, '2024-03-25', 'Processing', 35000.00),
(4, 4, 4, '2024-03-26', 'Completed', 42000.00),
(5, 5, 5, '2024-03-27', 'Pending', 39000.00);

-- Insert data into TestDrive
INSERT INTO TestDrive (TestDriveID, CustomerID, CarID, EmployeeID, Date, Time)
VALUES
(1, 1, 1, 1, '2024-03-15', '10:30:00'),
(2, 2, 2, 1, '2024-03-16', '14:00:00'),
(3, 3, 3, 5, '2024-03-17', '11:00:00'),
(4, 4, 4, 2, '2024-03-18', '15:00:00'),
(5, 5, 5, 4, '2024-03-19', '09:30:00');

-- Insert data into OrderEmployeeWorksOn
INSERT INTO OrderEmployeeWorksOn (OrderID, EmployeeID)
VALUES
(1, 1),
(2, 1),
(3, 5),
(4, 2),
(5, 4);

-- Insert data into CustomerTestDrives
INSERT INTO CustomerTestDrives (CustomerID, TestDriveCount)
VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1);

-- Example of SELECT
SELECT * FROM Car;

-- Example of UPDATE
UPDATE OrderTable
SET Status = 'Completed'
WHERE OrderID = 2;

-- Example of DELETE
DELETE FROM TestDrive
WHERE TestDriveID = 5;


-- Change the delimiter temporarily to define procedures
DELIMITER //

-- Procedure 1: Add a new car with validation for price and year
CREATE PROCEDURE AddNewCar(
    IN p_CarID INT,
    IN p_ManagerID INT,
    IN p_Make VARCHAR(50),
    IN p_Model VARCHAR(50),
    IN p_Year INT,
    IN p_Price DECIMAL(10,2),
    IN p_Type VARCHAR(50),
    IN p_Features TEXT
)
BEGIN
    IF p_Year < 1900 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Year must be 1900 or greater.';
    ELSEIF p_Price < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Price must be non-negative.';
    ELSE
        INSERT INTO Car (CarID, ManagerID, Make, Model, Year, Price, Type, Features)
        VALUES (p_CarID, p_ManagerID, p_Make, p_Model, p_Year, p_Price, p_Type, p_Features);
    END IF;
END //

DELIMITER //
-- Procedure 2: Update the order status with validation for order existence
CREATE PROCEDURE UpdateOrderStatus(
    IN p_OrderID INT,
    IN p_NewStatus VARCHAR(50)
)
BEGIN
    IF NOT EXISTS (SELECT 1 FROM OrderTable WHERE OrderID = p_OrderID) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Order not found.';
    ELSE
        UPDATE OrderTable
        SET Status = p_NewStatus
        WHERE OrderID = p_OrderID;
    END IF;
END //

-- Procedure 3: Delete a test drive with validation for test drive existence
CREATE PROCEDURE DeleteTestDrive(
    IN p_TestDriveID INT
)
BEGIN
    IF NOT EXISTS (SELECT 1 FROM TestDrive WHERE TestDriveID = p_TestDriveID) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Test Drive not found.';
    ELSE
        DELETE FROM TestDrive
        WHERE TestDriveID = p_TestDriveID;
    END IF;
END //

-- Procedure 4: Show all available cars
CREATE PROCEDURE ShowAvailableCars()
BEGIN
    SELECT * FROM Car
    WHERE Price IS NOT NULL;
END //

-- Procedure 5: Add a new customer with validation for email uniqueness
CREATE PROCEDURE AddNewCustomer(
    IN p_CustomerID INT,
    IN p_FirstName VARCHAR(50),
    IN p_MiddleName VARCHAR(50),
    IN p_LastName VARCHAR(50),
    IN p_Email VARCHAR(100),
    IN p_Phone VARCHAR(15),
    IN p_Street VARCHAR(255),
    IN p_City VARCHAR(50),
    IN p_State VARCHAR(50),
    IN p_ZipCode VARCHAR(10)
)
BEGIN
    IF EXISTS (SELECT 1 FROM Customer WHERE Email = p_Email) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Email already exists!';
    ELSE
        INSERT INTO Customer (CustomerID, FirstName, MiddleName, LastName, Email, Phone, Street, City, State, ZipCode)
        VALUES (p_CustomerID, p_FirstName, p_MiddleName, p_LastName, p_Email, p_Phone, p_Street, p_City, p_State, p_ZipCode);
    END IF;
END //

-- Reset the delimiter back to default
DELIMITER ;


-- View 1: Display detailed employee profile along with their manager's name
CREATE VIEW UserProfileView AS
SELECT 
    e.EmployeeID,
    e.FirstName,
    e.MiddleName,
    e.LastName,
    e.Email,
    e.Phone,
    e.Role,
    sm.ManagerID,
    sm.FirstName AS ManagerFirstName
FROM 
    Employee e
LEFT JOIN 
    ShowroomManager sm ON e.ManagerID = sm.ManagerID;

-- View 2: Display order details including customer name and car information
CREATE VIEW OrderDetailsView AS
SELECT 
    o.OrderID,
    c.FirstName AS CustomerFirstName,
    c.LastName AS CustomerLastName,
    ca.Make,
    ca.Model,
    o.OrderDate,
    o.Status,
    o.TotalPrice
FROM 
    OrderTable o
JOIN 
    Customer c ON o.CustomerID = c.CustomerID
JOIN 
    Car ca ON o.CarID = ca.CarID;


-- 1. UNION: Combine customer and employee names
SELECT FirstName, LastName FROM Customer
UNION
SELECT FirstName, LastName FROM Employee;

-- 2. INTERSECT (Simulated using IN): Find employees who are both working on orders and test drives
SELECT EmployeeID
FROM OrderEmployeeWorksOn
WHERE EmployeeID IN (SELECT EmployeeID FROM TestDrive);

-- 3. EXCEPT (Simulated using NOT IN): Find employees involved in test drives but not in order works
SELECT EmployeeID
FROM TestDrive
WHERE EmployeeID NOT IN (SELECT EmployeeID FROM OrderEmployeeWorksOn);

-- 4. DISTINCT: Display unique car types
SELECT DISTINCT Type FROM Car;

-- 5. Aggregate Function (COUNT): Count total number of customers
SELECT COUNT(*) AS TotalCustomers FROM Customer;

-- 6. Aggregate Function (MAX): Get the highest order price
SELECT MAX(TotalPrice) AS HighestOrder FROM OrderTable;

-- 7. Aggregate Function (AVG): Calculate the average car price
SELECT AVG(Price) AS AverageCarPrice FROM Car;

-- 8. IN: Display orders for specific customers
SELECT * FROM OrderTable
WHERE CustomerID IN (1, 2, 3);

-- 9. BETWEEN: Display cars priced between 25000 and 40000
SELECT * FROM Car
WHERE Price BETWEEN 25000 AND 40000;

-- 10. IS NULL: Display managers who do not have an assigned employee
SELECT * FROM ShowroomManager
WHERE EmployeeID IS NULL;

-- 11. NOT (IS NOT NULL): Display customers with a registered email
SELECT * FROM Customer
WHERE Email IS NOT NULL;

-- 12. LIKE: Display cars with 'Camera' mentioned in features
SELECT * FROM Car
WHERE Features LIKE '%Camera%';

-- 13. ALL/ANY: Display orders priced higher than all incomplete orders
SELECT * FROM OrderTable
WHERE TotalPrice > ALL (SELECT TotalPrice FROM OrderTable WHERE Status != 'Completed');

-- 14. Nested Query: Display employee names working on order ID 1
SELECT FirstName, LastName
FROM Employee
WHERE EmployeeID IN (SELECT EmployeeID FROM OrderEmployeeWorksOn WHERE OrderID = 1);

-- 15. GROUP BY + HAVING + ORDER BY: Display number of employees under each manager (more than 1)
SELECT ManagerID, COUNT(*) AS EmployeeCount
FROM Employee
GROUP BY ManagerID
HAVING COUNT(*) > 1
ORDER BY ManagerID;

-- 1. Add a new order and update the customer's test drive count
START TRANSACTION;

INSERT INTO OrderTable (OrderID, CustomerID, CarID, OrderDate, Status, TotalPrice)
VALUES (6, 1, 2, '2024-04-20', 'Pending', 28000.00);

UPDATE CustomerTestDrives
SET TestDriveCount = TestDriveCount + 1
WHERE CustomerID = 1;

COMMIT;

-- -----------------------------------

-- 2. Update the time of a specific test drive
START TRANSACTION;

UPDATE TestDrive
SET Time = '16:00:00'
WHERE TestDriveID = 3;
-- If the update fails (no rows affected), a ROLLBACK could be used (optional depending on the system)
COMMIT;

-- -----------------------------------

-- 3. Delete an order and its related records from OrderEmployeeWorksOn
START TRANSACTION;

DELETE FROM OrderEmployeeWorksOn
WHERE OrderID = 5;

DELETE FROM OrderTable
WHERE OrderID = 5;

COMMIT;

-- -----------------------------------

-- 4. Add a new test drive and update the customer's test drive count
START TRANSACTION;

INSERT INTO TestDrive (TestDriveID, CustomerID, CarID, EmployeeID, Date, Time)
VALUES (6, 1, 3, 2, '2024-04-22', '13:00:00');

UPDATE CustomerTestDrives
SET TestDriveCount = TestDriveCount + 1
WHERE CustomerID = 1;

COMMIT;