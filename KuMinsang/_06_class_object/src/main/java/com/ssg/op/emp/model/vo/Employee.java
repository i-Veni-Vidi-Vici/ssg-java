package com.ssg.op.emp.model.vo;

import java.util.Scanner;

public class Employee {
    Scanner sc = new Scanner(System.in);

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

    public void empInput(){

        System.out.print("사원번호를 입력하시오 : ");
        this.empNo = this.sc.nextInt();
        System.out.print("성함을 입력하시오 : ");
        this.empName = this.sc.next();
        System.out.print("부서를 입력하시오 : ");
        this.dept = this.sc.next();
        System.out.print("직무를 입력하시오 : ");
        this.job = this.sc.next();
        System.out.print("나이를 입력하시오 : ");
        this.age = this.sc.nextInt();
        System.out.print("성별을 입력하시오 : ");
        this.gender = this.sc.next().charAt(0);
        System.out.print("월급을 입력하시오 : ");
        this.salary = this.sc.nextInt();
        System.out.print("성과급을 입력하시오 : ");
        this.bonusPoint = this.sc.nextDouble();
        System.out.print("전화번호를 입력하시오 : ");
        this.phone = this.sc.next();
        System.out.print("주소를 입력하시오 : ");
        this.address = this.sc.next();


    }
    public void empOutput(){
            System.out.println("사원번호 : " + this.empNo);
            System.out.println("성함 : " + this.empName);
            System.out.println("부서 : " + this.dept);
            System.out.println("직무 : " + this.job);
            System.out.println("나이 : " + this.age);
            System.out.println("성별 : " + this.gender);
            System.out.println("월급 : " + this.salary);
            System.out.println("성과급 : " + this.bonusPoint);
            System.out.println("전화번호 : " + this.phone);
            System.out.println("주소 : " + this.address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
}
