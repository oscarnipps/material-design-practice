package com.example.materialpractice.databindingpractice.model;

public class Employee {

    private String employeeName;
    private String employeeDepartment;
    private double employeeAnnualPay;
    private int imageResourceId;
    private int id;

    public Employee(String employeeName, String employeeDepartment, double employeeAnnualPay) {
        this.employeeName = employeeName;
        this.employeeDepartment = employeeDepartment;
        this.employeeAnnualPay = employeeAnnualPay;
    }

    public Employee(int id , String firstName , String secondName ,String email) {

    }


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public double getEmployeeAnnualPay() {
        return employeeAnnualPay;
    }

    public void setEmployeeAnnualPay(double employeeAnnualPay) {
        this.employeeAnnualPay = employeeAnnualPay;
    }
}
