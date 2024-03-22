package com.ssg.oop.emp.model1.vo;

import java.util.Scanner;

public class Employee {
    //사원 정보 관리용 클래스
        Scanner sc = new Scanner(System.in);

    int empNo;
    String empName;
    String dept;
    String job;
    int age;
    char gender;
    int salary;
    double bonusPoint;
    String phone;
    String address;


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

    public void deleteEmp() {
        this.empNo = getEmpNo();
        this.empName = getEmpName();
        this.dept = getDept();
        this.job = getJob();
        this.age = getAge();
        this.gender = getGender();
        this.salary = getSalary();
        this.bonusPoint = getBonusPoint();
        this.phone = getPhone();
        this.address = getAddress();
    }
    public void empOutput(){
        System.out.println("dkssud");
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
