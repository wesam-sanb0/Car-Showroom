/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author layannawaf
 */
import java.time.LocalDate;

public class Order {
    private String orderID;
    private double totalPrice;
    private String status;
    private LocalDate orderDate;
    private String carID;
    private String customerID;

    // Constructor
    public Order(String orderID, double totalPrice, String status, LocalDate orderDate, String carID, String customerID) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
        this.carID = carID;
        this.customerID = customerID;
    }

    // Getter methods
    public String getOrderID() {
        return orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getCarID() {
        return carID;
    }

    public String getCustomerID() {
        return customerID;
    }

    // Setter methods
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // toString method to print the Order details
    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Total Price: $" + totalPrice + ", Status: " + status + 
               ", Order Date: " + orderDate + ", Car ID: " + carID + ", Customer ID: " + customerID;
    }

   
}




