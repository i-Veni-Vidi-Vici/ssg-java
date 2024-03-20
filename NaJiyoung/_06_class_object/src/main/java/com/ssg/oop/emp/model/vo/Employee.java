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

    public void empInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("사번: ");
        this.empNo = sc.nextInt();
        System.out.print("이름: ");
        this.empName = sc.next();
        System.out.print("소속부서: ");
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
        sc.nextLine();
        System.out.print("주소: ");
        this.address = sc.nextLine();
    }

    public void empOutput() {
        System.out.printf("사번: %d, 이름: %s, 소속부서: %s, 직급: %s, 나이: %d, 성별: %s, 급여: %d, 보너스포인트: %.1f, 핸드폰: %s, 주소: %s\n\n",
                getEmpNo(), getEmpName(), getDept(), getJob(), getAge(), getGender(), getSalary(), getBonusPoint(), getPhone(), getAddress());
    }

    public void setEmpNo(int empNo) {this.empNo = empNo;}
    public int getEmpNo() {return this.empNo = empNo;}

    public void setEmpName(String empName) {this.empName = empName;}
    public String getEmpName() {return this.empName = empName;}

    public void setDept(String dept) {this.dept = dept;}
    public String getDept() {return this.dept = dept;}

    public void setJob(String job) {this.job = job;}
    public String getJob() {return this.job = job;}

    public void setAge(int age) {this.age = age;}
    public int getAge() {return this.age = age;}

    public void setGender(char gender) {this.gender = gender;}
    public char getGender() {return this.gender = gender;}

    public void setSalary(int salary) {this.salary = salary;}
    public int getSalary() {return this.salary = salary;}

    public void setBonusPoint(double bonusPoint) {this.bonusPoint = bonusPoint;}
    public double getBonusPoint() {return this.bonusPoint = bonusPoint;}

    public void setPhone(String phone) {this.phone = phone;}
    public String getPhone() {return this.phone = phone;}

    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return this.address = address;}
}
