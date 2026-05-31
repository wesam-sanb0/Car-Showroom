/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author Shoaaa
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class TestDrive {
    private String testDriveID;
    private String customerID;
    private String carID;
    private String employeeID;
    private LocalDate date;
    private LocalTime time;

    // Constructor with validation
    public TestDrive(String testDriveID, String customerID, String carID, String employeeID, LocalDate date, LocalTime time) {
        if (testDriveID == null || testDriveID.isEmpty()) throw new IllegalArgumentException("TestDrive ID cannot be null or empty.");
        if (customerID == null || customerID.isEmpty()) throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        if (carID == null || carID.isEmpty()) throw new IllegalArgumentException("Car ID cannot be null or empty.");
        if (employeeID == null || employeeID.isEmpty()) throw new IllegalArgumentException("Employee ID cannot be null or empty.");
        if (date == null) throw new IllegalArgumentException("Date cannot be null.");
        if (time == null) throw new IllegalArgumentException("Time cannot be null.");

        this.testDriveID = testDriveID;
        this.customerID = customerID;
        this.carID = carID;
        this.employeeID = employeeID;
        this.date = date;
        this.time = time;
    }

    // Getter methods
    public String getTestDriveID() {
        return testDriveID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCarID() {
        return carID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    // Setter methods with validation
    public void setDate(LocalDate date) {
        if (date == null) throw new IllegalArgumentException("Date cannot be null.");
        this.date = date;
    }

    public void setTime(LocalTime time) {
        if (time == null) throw new IllegalArgumentException("Time cannot be null.");
        this.time = time;
    }

    // toString method
    @Override
    public String toString() {
        return "TestDrive ID: " + testDriveID + ", Customer ID: " + customerID + ", Car ID: " + carID +
               ", Employee ID: " + employeeID + ", Date: " + date + ", Time: " + time;
    }
}




