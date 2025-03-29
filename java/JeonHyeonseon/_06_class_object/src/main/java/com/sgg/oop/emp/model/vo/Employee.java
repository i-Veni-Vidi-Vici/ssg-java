package com.sgg.oop.emp.model.vo;

import com.sgg.oop.emp.run.EmpTest;

import java.util.Scanner;

public class Employee {

    private int empNo; // 사번
    private String empName; // 이름
    private String dept; // 소속부서
    private String job; // 직급
    private int age; // 나이
    private char gender; // 성별
    private int salary; // 급여
    private double bonusPoint; // 보너스포인트
    private String phone; // 핸드폰
    private String address; // 주소

    // 키보드입력용메소드 -> 키보드 입력 : Scanner 사용
    public void empInput(){
        Scanner sc = new Scanner(System.in);

        System.out.println("사번을 입력하세요 : ");
        this.empNo = sc.nextInt(); // this는 Employee
        System.out.println("이름을 입력하세요 : ");
        this.empName = sc.next();
        System.out.println("소속부서를 입력하세요 : ");
        this.dept = sc.next();
        System.out.println("직급을 입력하세요 : ");
        this.job = sc.next();
        System.out.println("나이를 입력하세요 : ");
        this.age = sc.nextInt();
        System.out.println("성별을 입력하세요 : ");
        this.gender = sc.next().charAt(0);
        System.out.println("급여를 입력하세요 : ");
        this.salary = sc.nextInt();
        System.out.println("보너스포인트를 입력하세요 : ");
        this.bonusPoint = sc.nextDouble();
        System.out.println("전화번호 입력하세요 : ");
        this.phone = sc.next();
        System.out.println("주소를 입력하세요 : ");
        this.address = sc.nextLine();
    }

    // emp객체 모든 필드 출력용 메소드
    public void empOutput() {
        String str = "사번 : " + this.empNo;
        str += "\n이름 : " + this.empName;
        str += "\n소속부서 : " + this.dept;
        str += "\n직급 : " + this.job;
        str += "\n나이 : " + this.age;
        str += "\n성별 : " + this.gender;
        str += "\n급여 : " + this.salary;
        str += "\n보너스포인트 : " + this.bonusPoint;
        str += "\n핸드폰 : " + this.phone;
        str += "\n주소 : " + this.address;
        System.out.println(str);
    }

    // getter/setter 메소드
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
