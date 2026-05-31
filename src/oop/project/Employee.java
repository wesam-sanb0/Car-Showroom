/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.project;

/**
 *
 * @author layannawaf
 */
public class Employee {
    private String employeeID;
    private String Fname;
    private String Mname;
    private String Lname;
    private String email;
    private String phone;
    private String role;
    private String managerID;

    // Constructor
    public Employee(String employeeID, String Fname, String Mname, String Lname, String email, String phone, String role, String managerID) {
        this.employeeID = employeeID;
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.managerID = managerID;
    }

    // Getter methods
    public String getEmployeeID() {
        return employeeID;
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

    public String getRole() {
        return role;
    }

    public String getManagerID() {
        return managerID;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    // toString method for printing the Employee details
    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + Fname + " " + Mname + " " + Lname + ", Role: " + role + ", Manager ID: " + managerID;
    }

   
}















