package com.ohgiraffer;

public class EmployeeDTO {
    private int empNo;
    private String empName;
    private String dept;
    private String job;
    private int age;
    private char gender;
    private int salary;
    private double bonusPoint;
    private String phone;
    private String address;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empNo, String empName, int age, char gender, String phone, String address) {
        this.empNo = empNo;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }
    public EmployeeDTO(int empNo, String empName, String dept, String job, int age, char gender, int salary, double bonusPoint, String phone, String address) {
        this.empNo = empNo;
        this.empName = empName;
        this.dept = dept;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.bonusPoint = bonusPoint;
        this.phone = phone;
        this.address = address;
    }

    public String information(int empNo, String empName, String dept, String job, int age, char gender, int salary, double bonusPoint, String phone, String address){
        return this.empNo + ", " + this.empName + ", " + this.dept + "," + this.job + ", " + this.age + ", " + this.gender + ", " + this.salary + ", " + this.bonusPoint + ", " + this.phone + ", " + this.address;
    }
}
