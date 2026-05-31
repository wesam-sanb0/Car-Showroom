/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author layannawaf
 */
public class Customer {
    private String customerID;
    private String Fname;
    private String Mname;
    private String Lname;
    private String email;
    private String phone;
    private String zipcode;
    private String city;
    private String street;
    private String state;

    // Constructor
    public Customer(String customerID, String Fname, String Mname, String Lname, String email, String phone, 
                    String zipcode, String city, String street, String state) {
        this.customerID = customerID;
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.email = email;
        this.phone = phone;
        this.zipcode = zipcode;
        this.city = city;
        this.street = street;
        this.state = state;
    }

    // Getter methods
    public String getCustomerID() {
        return customerID;
    }

    public String getFname() {
        return Fname;
    }

    public String getMname() {
        return Mname;
    }

    public String getLname() {
        return Lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    // Setter methods
    public void setFname(String fname) {
        this.Fname = fname;
    }

    public void setMname(String mname) {
        this.Mname = mname;
    }

    public void setLname(String lname) {
        this.Lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    // toString method to print the customer details
    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + Fname + " " + Mname + " " + Lname + 
               ", Email: " + email + ", Phone: " + phone + ", Address: " + street + ", " + city + 
               ", " + state + " " + zipcode;
    }

    
}



