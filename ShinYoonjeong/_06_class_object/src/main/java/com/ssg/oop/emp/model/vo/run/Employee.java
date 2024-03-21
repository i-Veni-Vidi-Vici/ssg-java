package com.ssg.oop.emp.model.vo.run;

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

    public static void emInput() {
    }

    public static void emOutput() {
    }

    public void init(int empNo, String empName, String dept, String job, int age, char gender, int salary, double bonusPoint, String phone, String address)
    {
        this.empNo = empNo;
        this.empName = empName;
        this.dept = dept;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.bonusPoint = bonusPoint;
        this.phone = phone;
        this.address = address;
    }

    public void empInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("사번");
        empNo = sc.nextInt();
        System.out.println("이름");
        empName = sc.next();
        System.out.println("소속 부서");
        dept = sc.next();
        System.out.println("직급");
        job = sc.next();
        System.out.println("나이");
        age = sc.nextInt();
        System.out.println("성별");
        gender = sc.next().charAt(0);
        System.out.println("급여");
        salary = sc.nextInt();
        System.out.println("보너스 포인트");
        bonusPoint = sc.nextDouble();
        System.out.println("핸드폰");
        phone = sc.next();
        System.out.println("주소");
        address = sc.next();
    }

    public void empOutput() {
    }
}
