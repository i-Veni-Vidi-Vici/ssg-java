package com.ssg.oop.emp.mode1.vo;

import java.util.Scanner;

public class Employee {
    private int empNo; // 사번
    private String empName; // 이름
    private String dept; // 소속부서
    private String job; // 직급
    private int age; // 나이
    private char gender ; // 성별
    private int salary ; // 급여
    private double bonusPoint ; // 보너스포인트
    private String phone; // 핸드폰
    private String address; // 주소



    // 키보드입력용 메소드
    public void empInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print(">사번 입력해주세요: ");
        setEmpNo(sc.nextInt());
        sc.nextLine(); // 개행문자버림
        System.out.print(">이름 입력해주세요: ");
        setEmpName(sc.nextLine());
        System.out.print(">소속부서 입력해주세요: ");
        setDept(sc.nextLine());
        System.out.print(">직급 입력해주세요: ");
        setJob(sc.nextLine());
        System.out.print(">나이 입력해주세요: ");
        setAge(sc.nextInt());
        sc.nextLine();
        System.out.print(">성별(F/M) 입력해주세요: ");
        setGender(sc.next().charAt(0));
        System.out.print(">급여 입력해주세요: ");
        setSalary(sc.nextInt());
        System.out.print(">보너스포인트 입력해주세요: ");
        setBonusPoint(sc.nextDouble());
        sc.nextLine();
        System.out.print(">핸드폰 입력해주세요: ");
        setPhone(sc.nextLine());
        System.out.print(">주소 입력해주세요: ");
        setAddress(sc.nextLine());
    }

    // emp객체 모든 필드 출력용 메서드
    public void empOutput(){
        System.out.printf("사번 : %d,이름 : %s,소속부서: %s,직급 : %s,나이 : %d,성별 : %c,급여 : %d,보너스포인트: %.2f,핸드폰: %s,주소 : %s "
        ,getEmpNo(),getEmpName(),getDept(),getJob(),getAge(),getGender(),getSalary(),getBonusPoint(),getPhone(),getAddress());

    }

    // getter setter

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
