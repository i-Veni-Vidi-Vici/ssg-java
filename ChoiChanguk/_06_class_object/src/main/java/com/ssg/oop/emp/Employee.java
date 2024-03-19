package com.ssg.oop.emp;

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

    public Employee(){

    }

    public void empInput()
    {
        if(getEmpNo()==0)
        {
            System.out.println("입력된 값이 없어 출력을 안합니다");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("사번 : ");
        setEmpNo(sc.nextInt());
        System.out.print("이름 : ");
        setEmpName(sc.next());
        System.out.print("소속부서 : ");
        setDept(sc.next());
        System.out.print("직급 : ");
        setJob(sc.next());
        System.out.print("나이 : ");
        setAge(sc.nextInt());
        System.out.print("성별 : ");
        setGender(sc.next().charAt(0));
        System.out.print("급여 : ");
        setSalary(sc.nextInt());
        System.out.print("보너스포인트 : ");
        setBonusPoint(sc.nextDouble());
        System.out.print("핸드폰 : ");
        setPhone(sc.next());
        System.out.print("주소 : ");
        setAddress(sc.next());
    }

    public void empOutput() {
        System.out.println("사번 : "+getEmpNo());
        System.out.println("이름: "+getEmpName());
        System.out.println("소속부터 : "+getDept());
        System.out.println("직급 : "+getJob());
        System.out.println("나이 : "+getAge());
        System.out.println("성별 : "+getGender());
        System.out.println("급여 : "+getSalary());
        System.out.println("보너스포인트 : "+getBonusPoint());
        System.out.println("핸드폰 : "+getPhone());
        System.out.println("주소 : "+getAddress());

    }

    public int getEmpNo() {
        return this.empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBonusPoint() {
        return this.bonusPoint;
    }

    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
