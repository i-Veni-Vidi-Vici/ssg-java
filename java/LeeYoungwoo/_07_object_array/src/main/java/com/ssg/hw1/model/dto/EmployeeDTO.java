package com.ssg.hw1.model.dto;

import java.awt.datatransfer.StringSelection;

/**
 *`-` private
 *`~` default
 *`#` protected
 *`+` public
 * 밑줄은 static을 의미합니다.
 */
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

    // 생성자
    public EmployeeDTO(){}

    public EmployeeDTO(int empNo, String empName, int age,
                       char gender, String phone, String address){

        this.empNo = empNo;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public EmployeeDTO(int empNo, String empName, String dept, String job, int age, char gender,
                       int salary, double bonusPoint, String phone, String address){
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

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 메소드
    public String information(){
        System.out.print(getEmpNo() + ", ");
        System.out.print(getEmpName() + ", ");
        System.out.print(getDept() + ", ");
        System.out.print(getJob() + ", ");
        System.out.print(getAge() + ", ");
        System.out.print(getGender() + ", ");
        System.out.print(getSalary() + ", ");
        System.out.print(getBonusPoint() + ", ");
        System.out.print(getPhone() + ", ");
        System.out.print(getAddress() + "\n");
        return "";
    }


}
