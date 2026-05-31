 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author layannawaf
 */
public class Car {
    private String carID;
    private String make;
    private String model;
    private int Caryear;
    private double price;
    private String type;
    private String feature;
    private String managerID;
    private String imagePath;

    // Constructor
    public Car(String carID, String make, String model, int year, double price, String type, String feature, String managerID, String imagePath) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.Caryear = year;
        this.price = price;
        this.type = type;
        this.feature = feature;
        this.managerID = managerID;
        this.imagePath = imagePath;
    }

    // Getter methods
    public String getCarID() {
        return carID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return Caryear;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getFeature() {
        return feature;
    }

    public String getManagerID() {
        return managerID;
    }

    // Setter methods
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.Caryear = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // toString method to print the Car details
    @Override
    public String toString() {
        return "Car ID: " + carID + ", Make: " + make + ", Model: " + model + ", Year: " + Caryear + 
               ", Price: $" + price + ", Type: " + type + ", Feature: " + feature + ", Manager ID: " + managerID + ", Image Path: " + imagePath;
    }

    
}



