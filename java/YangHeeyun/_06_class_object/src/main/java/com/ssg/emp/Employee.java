package com.ssg.emp;
import java.util.Scanner;
public class Employee {
    Scanner sc = new Scanner(System.in);
    private int empNo; //사번
    private String empName; //이름
    private String dept;  //소속부서
    private String job;  //직급
    private int age; //나이
    private char gender;  //성별
    private int salary; //급여
    private double bonusPoint;  //보너스포인트
    private String phone; //핸드폰
    private String address; //주소

    //키보드입력용 메소드
    public void empInput(){
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
        System.out.print("주소: ");
        this.address = sc.next();
    }

    // emp객체 모든 필드 출력용 메소드
    public void empOutput(){
        System.out.println("사번: "+getEmpNo());
        System.out.println("이름: "+getEmpName());
        System.out.println("소속부서: "+getDept());
        System.out.println("직급: "+getJob());
        System.out.println("나이: "+getAge());
        System.out.println("성별: "+getGender());
        System.out.println("급여: "+getSalary());
        System.out.println("보너스포인트: "+getBonusPoint());
        System.out.println("핸드폰: "+getPhone());
        System.out.println("주소: "+getAddress());
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
