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
    private double bonusPoint;
    private String phone;
    private String address;

    // 생성자
    public Employee() {
    }

    // Getter와 Setter 메서드
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

    // 1. 키보드 입력용 메소드
    public void empInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사원 번호 입력: ");
        this.setEmpNo(scanner.nextInt());
        System.out.print("사원 이름 입력: ");
        this.setEmpName(scanner.nextLine());//nextInt 한 후 Enter 입력이 nextLine으로 넘어가서 Enter 삭제를 위해 한번 더 선언
        this.setEmpName(scanner.nextLine());
        System.out.print("소속 부서 입력: ");
        this.setDept(scanner.nextLine());
        System.out.print("직급 입력: ");
        this.setJob(scanner.nextLine());
        System.out.print("나이 입력: ");
        this.setAge(scanner.nextInt());
        System.out.print("성별 입력 (M/F): ");
        this.setGender(scanner.next().charAt(0));
        System.out.print("급여 입력: ");
        this.setSalary(scanner.nextInt());
        System.out.print("보너스 포인트 입력: ");
        this.setBonusPoint(scanner.nextDouble());
        System.out.print("핸드폰 번호 입력: ");
        this.setPhone(scanner.nextLine());
        this.setPhone(scanner.nextLine());
        System.out.print("주소 입력: ");
        this.setAddress(scanner.nextLine());
    }

    // 사원 정보 출력하는 메서드
    public void empOutput() {
        System.out.println();
        System.out.println("사원 번호: " + this.getEmpNo());
        System.out.println("사원 이름: " + this.getEmpName());
        System.out.println("소속 부서: " + this.getDept());
        System.out.println("직급: " + this.getJob());
        System.out.println("나이: " + this.getAge());
        System.out.println("성별: " + this.getGender());
        System.out.println("급여: " + this.getSalary());
        System.out.println("보너스 포인트: " + this.getBonusPoint());
        System.out.println("핸드폰 번호: " + this.getPhone());
        System.out.println("주소: " + this.getAddress());
        System.out.println();
    }
}