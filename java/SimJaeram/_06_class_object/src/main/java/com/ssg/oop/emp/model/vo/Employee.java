package com.ssg.oop.emp.model.vo;

import java.util.Scanner;

/**
 * 사원 정보 관리용 클래스
 */
public class Employee {
    private Scanner sc = new Scanner(System.in);

    // 필드
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

    // 메소드
    // 1. 키보드입력용 메소드
    public void empInput() {
        System.out.print("사번 입력 : ");
        empNo = sc.nextInt();
        System.out.print("이름 입력 : ");
        empName = sc.next();
        System.out.print("소속부서 입력 : ");
        dept = sc.next();
        System.out.print("직급 입력 : ");
        job = sc.next();
        System.out.print("나이 입력 : ");
        age = sc.nextInt();
        System.out.print("성별 입력 : ");
        gender = sc.next().charAt(0);
        System.out.print("급여 입력 : ");
        salary = sc.nextInt();
        System.out.print("보너스 포인트 입력 : ");
        bonusPoint = sc.nextDouble();
        System.out.print("핸드폰 입력 : ");
        phone = sc.next();
        System.out.print("주소 입력 : ");
        address = sc.next();
    }

    // 2. emp객체 모든 필드 출력용 메소드
    public void empOutput() {
        System.out.printf("%d, %s, %s, %s, %d, %c, %d, %f, %s, %s\n"
                , empNo, empName, dept, job, age, gender, salary, bonusPoint, phone, address);
    }

    // 3. setter, getter
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmpNo() {
        return this.empNo;
    }
    public String getEmpName() {
        return this.empName;
    }
    public String getDept() {
        return this.dept;
    }
    public String getJob() {
        return this.job;
    }
    public int getAge() {
        return this.age;
    }
    public char getGender() {
        return this.gender;
    }
    public int getSalary() {
        return this.salary;
    }
    public double getBonusPoint() {
        return this.bonusPoint;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getAddress() {
        return this.address;
    }
}
