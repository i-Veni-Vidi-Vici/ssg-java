package com.ssg.oop.emp.model.vo;

import java.util.Arrays;
import java.util.Scanner;

public class Employee {
    // field
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

    String empInfo = "";
    int empNum = 0;
    String[][] empInfomation = new String[1][empNum];

    public Employee() {}

    // 키보드입력용 메소드
    public void empInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력 : ");
//        this.empNo = sc.nextInt();
        empInfo += sc.nextInt() + ", ";
        System.out.print("이름 입력 : ");
//        this.empName = sc.next();
        empInfo += sc.next() + ", ";
        System.out.print("소속부서 입력 : ");
//        this.dept = sc.next();
        empInfo += sc.next() + ", ";
        System.out.print("직급 입력 : ");
//        this.job = sc.next();
        empInfo += sc.next() + ", ";
        System.out.print("나이 입력 : ");
//        this.age = sc.nextInt();
        empInfo += sc.nextInt() + ", ";
        System.out.print("성별 입력 : ");
//        this.gender = sc.next().charAt(0);
        empInfo += sc.next().charAt(0) + ", ";
        System.out.print("급여 입력 : ");
//        this.salary = sc.nextInt();
        empInfo += sc.nextInt() + ", ";
        System.out.print("보너스포인트 입력 : ");
//        this.bonusPoint = sc.nextDouble();
        empInfo += sc.nextDouble() + ", ";
        System.out.print("핸드폰 입력 : ");
//        this.phone = sc.next();
        empInfo += sc.next() + ", ";
        sc.nextLine();
        System.out.print("주소 입력 : ");
//        this.address = sc.nextLine();
        empInfo += sc.nextLine();

        empInfomation[1][empNum] = empInfo;
        System.out.println(Arrays.toString(empInfomation));
        empNum++;
    }

    public void empDelete() {

    }

    // emp객체 모든 필드 출력용 메소드
    public void empOutput() {

    }

    // getter, setter
    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    public int getEmpNo() {
        return this.empNo;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpName() {
        return this.empName;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getDept() {
        return this.dept;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getJob() {
        return this.job;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return this.gender;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSalary() {
        return this.salary;
    }
    public void setBonusPoint(double bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
    public double getBonusPoint() {
        return this.bonusPoint;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

}
