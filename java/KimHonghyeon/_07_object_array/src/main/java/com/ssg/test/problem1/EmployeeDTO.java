package com.ssg.test.problem1;

public class EmployeeDTO {
    private int empNo, age, salary;
    private String empName, dept, job, phone, address;
    private char gender;
    private double bonusPoint;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empNo, int age, String empName, String phone, String address, char gender) {
        this.empNo = empNo;
        this.age = age;
        this.empName = empName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public EmployeeDTO(int empNo, int age, int salary, String empName, String dept, String job,
                       String phone, String address, char gender, double bonusPoint) {
        this.empNo = empNo;
        this.age = age;
        this.salary = salary;
        this.empName = empName;
        this.dept = dept;
        this.job = job;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bonusPoint = bonusPoint;
    }

    public String info(){
        return "empNo: " + this.empNo + " name: " + this.empName + " dept: " + this.dept + "job: "+ this.job + " age: "
                + this.age + " gender: "+ this.gender +  " phone: " + this.phone + " address: " + this.address;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
}
