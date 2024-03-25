package com.ssg.oop.emp.model1.vo;

import java.util.Scanner;

public class Employee {
    //사원 정보 관리용 클래스

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

    public Employee() {
    }


    public void empInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("사번 : ");
        this.empNo = sc.nextInt();

        System.out.print("이름 : ");
        this.empName = sc.next();

        System.out.print("소속 부서 : ");
        this.dept = sc.next();

        System.out.print("나이 : ");
        this.age = sc.nextInt();

        System.out.print("성별 : ");
        this.gender = sc.next().charAt(0);

        System.out.print("급여 : ");
        this.salary = sc.nextInt();

        System.out.print("보너스 포인트 : ");
        this.bonusPoint = sc.nextInt();

        System.out.print("핸드폰 : ");
        this.phone = sc.next();

        System.out.print("주소 : ");
        this.address = sc.nextLine();
        sc.nextLine();
    }

    public void empOutput(){

        System.out.println("*************************************");
        System.out.printf("사번 :  %d\n", this.empNo);
        System.out.printf("이름 :  %s\n", this.empName);
        System.out.printf("소속 부서 :  %s\n", this.dept);
        System.out.printf("나이 :  %d\n", this.age);
        System.out.printf("성별 :  %s\n", this.gender);
        System.out.printf("급여 :  %d\n", this.salary);
        System.out.printf("보너스 포인트 : " + this.bonusPoint + "\n");
        System.out.printf("핸드폰 : %s\n", this.phone);
        System.out.printf("주소 : %s\n", this.address);
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
