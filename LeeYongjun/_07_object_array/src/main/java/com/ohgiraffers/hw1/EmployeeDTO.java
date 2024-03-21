package com.ohgiraffers.hw1;

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
    private int yearSalary;
    public void EmployeeDTO() {}

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

    public EmployeeDTO(String empName, int salary, double bonusPoint) {
        this.empName = empName;
        this.salary = salary;
        this.bonusPoint = bonusPoint;
    }

    public EmployeeDTO(int yearSalary) {
        this.yearSalary = yearSalary;
    }

    public void info() {
        System.out.printf("emp[%d] : %d, %s, %s, %s, %d, %c, %d, %.2f, %s, %s \n",empNo,empNo,empName,dept,job,age,gender,salary,bonusPoint,phone,address);
    }


    public void hap() {
        yearSalary = (int) ((salary +(salary * bonusPoint))*12);
        System.out.printf("%s의 연봉 : %d원 \n",empName,yearSalary);
    }


    public int getYearSalary() {
        return yearSalary;
    }
}
