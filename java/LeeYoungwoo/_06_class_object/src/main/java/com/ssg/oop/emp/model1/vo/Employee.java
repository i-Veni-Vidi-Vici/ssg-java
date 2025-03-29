package com.ssg.oop.emp.model1.vo;

import java.util.Scanner;

/**
 * 사원정보 관리용 클래스
 */
public class Employee {
    // 필드 작성(캡슐화 적용할 것)
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
    Scanner sc = new Scanner(System.in);

    // 메소드 작성
    public void empInput(){
        System.out.println("> 사번 입력 : ");
        setEmpNo(sc.nextInt());
        System.out.println("> 이름 입력 : ");
        setEmpName(sc.next());
        System.out.println("> 소속부서 입력 : ");
        setDept(sc.next());
        System.out.println("> 직급 입력 : ");
        setJob(sc.next());
        System.out.println("> 나이 입력 : ");
        setAge(sc.nextInt());
        System.out.println("> 성별 입력 : ");
        setGender(sc.next().charAt(0));
        System.out.println("> 급여 입력 : ");
        setSalary(sc.nextInt());
        System.out.println("> 보너스 포인트 입력 : ");
        setBonusPoint(sc.nextDouble());
        System.out.println("> 핸드폰 입력 : ");
        setPhone(sc.next());
        System.out.println("> 주소 입력 : ");
        setAddress(sc.next());
    }
    public void empOutput(){
            System.out.println("사번 : " + getEmpNo());
            System.out.println("이름 : " + getEmpName());
            System.out.println("소속부서 : " + getDept());
            System.out.println("직급 : " + getJob());
            System.out.println("나이 : " + getAge());
            System.out.println("성별 : " + getGender());
            System.out.println("급여 : " + getSalary());
            System.out.println("보너스포인트 : " + getBonusPoint());
            System.out.println("핸드폰 : " + getPhone());
            System.out.println("주소 : " + getAddress());
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
