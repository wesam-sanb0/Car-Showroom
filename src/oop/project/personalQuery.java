/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author layannawaf
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class personalQuery {

    private static final String DATABASE_URI = "jdbc:derby://localhost:1527/ShowroomPlatForm";
    private static final String USERNAME = "oopproject";
    private static final String PASSWORD = "oopproject";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URI, USERNAME, PASSWORD);
    }


    public void insertCustomer(String id, String firstName, String middleName, String lastName, String email,
                                String phone, String zip, String city, String street, String state) {
        String sql = "INSERT INTO Customer (CustomerID, FirstName, MiddleName, LastName, Email, Phone, ZipCode, City, Street, State) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, middleName);
            stmt.setString(4, lastName);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            stmt.setString(7, zip);
            stmt.setString(8, city);
            stmt.setString(9, street);
            stmt.setString(10, state);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer registered successfully! Please login.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertEmployee(String id, String firstName, String middleName, String lastName, String email, String phone) {
        String sql = "INSERT INTO Employee (EmployeeID , FirstName, MiddleName , LastName, Email, Phone , Role , ManagerID) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, middleName);
            stmt.setString(4, lastName);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            stmt.setString(7,"sales manager");
            stmt.setInt(8,1);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee registered successfully!Please log in.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
public boolean insertCar(int carId, String make, String model, int year, double price, String type, String features, String imagePath) {
    String sql = "INSERT INTO Car (CarID, Make, Model, CarYear, Price, Type, Features, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, carId);
        pstmt.setString(2, make);
        pstmt.setString(3, model);
        pstmt.setInt(4, year);
        pstmt.setDouble(5, price);
        pstmt.setString(6, type);
        pstmt.setString(7, features);
        pstmt.setString(8, imagePath);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Car added successfully! Car ID: " + carId);
            return true;
        }

        return false;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
public int getVerifiedCustomerID(String email, String id) {
    String sql = "SELECT CustomerID FROM Customer WHERE Email = ? AND CustomerID = ?";
    try (Connection conn = getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, email);
        pst.setString(2, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("CustomerID");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
    }
    return -1;
}
public int getVerifiedEmployeeID(String email, String id) {
    String sql = "SELECT EmployeeID FROM Employee WHERE Email = ? AND EmployeeID = ?";
    try (Connection conn = getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, email);
        pst.setString(2, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("EmployeeID");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
    }
    return -1;
}


}