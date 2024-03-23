package com.ssg.oop.emp.model1.vo;

import java.util.Scanner;

public class Employee {
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
        Scanner sc = new Scanner(System.in);

        System.out.print("사번: ");
        this.empNo = sc.nextInt();
        System.out.print("이름: ");
        this.empName = sc.next();
        System.out.println("소속부서: ");
        this.dept = sc.next();
        System.out.print("직급: ");
        this.job = sc.next();
        System.out.print("나이: ");
        this.age = sc.nextInt();
        System.out.print("성별: ");
        this.gender = sc.next().charAt(0);
        System.out.print("급여: ");
        this.salary = sc.nextInt();
        System.out.print("보너스포인트: ");
        this.bonusPoint = sc.nextDouble();
        System.out.print("핸드폰: ");
        this.phone = sc.next();
        sc.nextLine(); // 13 10 날리기용
        System.out.print("주소: ");
        this.address = sc.nextLine();
    }

    public void empOutput(){
        String str = "사번: " + this.empNo;
        str += "\n이름: " + this.empName;
        str += "\n소속부서: " + this.dept;
        str += "\n직급: " + this.job;
        str += "\n나이: " + this.age;
        str += "\n성별: " + this.gender;
        str += "\n급여: " + this.salary;
        str += "\n보너스포인트: " + this.bonusPoint;
        str += "\n핸드폰: " + this.phone;
        str += "\n주소: " + this.address;
        System.out.println(str);
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

}
