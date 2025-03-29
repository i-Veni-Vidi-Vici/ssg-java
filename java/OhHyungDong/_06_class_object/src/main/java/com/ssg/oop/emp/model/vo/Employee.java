package com.ssg.oop.emp.model.vo;

import java.util.Scanner;

public class Employee {
    private int empNo;
    private String empName;
    private String dept;
    private String job;
    private int age;
    private char gender;

    private int salary;
    private double bounuspoint;
    private String phone;
    private String address;


    //값 입력
    public void empInput(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("사번 : "); this.empNo = scanner.nextInt();
            System.out.print("이름 : "); this.empName = scanner.next();
            System.out.print("소속부서 : "); this.dept = scanner.next();
            System.out.print("직급 : "); this.job = scanner.next();
            System.out.print("나이 : "); this.age = scanner.nextInt();
            System.out.print("성별 : "); this.gender = scanner.next().charAt(0);
            System.out.print("급여 : "); this.salary = scanner.nextInt();
            System.out.print("보너스포인트 : "); this.bounuspoint = scanner.nextDouble();
            System.out.print("핸드폰 : "); this.phone = scanner.next();
            System.out.print("주소 : "); this.address = scanner.next();
    }


    //값 출력
    public void empOutput(){


            System.out.println("사번 : " + this.empNo );
            System.out.println("이름 : " + this.empName);
            System.out.println("소속부서 : " + this.dept);
            System.out.println("직급 : " + this.job);
            System.out.println("나이 : " + this.age);
            System.out.println("성별 : " + this.gender);
            System.out.println("급여 : " + this.salary);
            System.out.println("보너스포인트 : " + this.bounuspoint);
            System.out.println("핸드폰 : " + this.phone);
            System.out.println("주소 : " + this.address);

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

    public double getBounuspoint() {
        return bounuspoint;
    }

    public void setBounuspoint(double bounuspoint) {
        this.bounuspoint = bounuspoint;
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
}
