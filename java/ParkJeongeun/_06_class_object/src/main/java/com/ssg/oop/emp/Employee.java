package com.ssg.oop.emp;

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

    void empInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----------새 사원 정보 입력----------");
        System.out.print("> 사번 입력 : ");
        setEmpNo(sc.nextInt());
        sc.nextLine();
        System.out.print("> 이름 입력 : ");
        setEmpName(sc.nextLine());
        System.out.print("> 소속부서 입력 : ");
        setDept(sc.nextLine());
        System.out.print("> 직급 입력 : ");
        setJob(sc.nextLine());
        System.out.print("> 나이 입력 : ");
        setAge(sc.nextInt());
        System.out.print("> 성별 입력 : ");
        setGender(sc.next().charAt(0));
        System.out.print("> 급여 입력 : ");
        setSalary(sc.nextInt());
        System.out.print("> 보너스포인트 입력 : ");
        setBonusPoint(sc.nextDouble());
        sc.nextLine();
        System.out.print("> 핸드폰 입력 : ");
        setPhone(sc.nextLine());
        System.out.print("> 주소 입력 : ");
        setAddress(sc.nextLine());
        System.out.println("----------------------------");
    }

    void empOutput(){
        String result = """
                ----------사원 정보 출력----------
                1. 사번 : %d
                2. 이름 : %s
                3. 소속부서 : %s
                4. 직급 : %s
                5. 나이 : %d
                6. 성별 : %s
                7. 급여 : %d
                8. 보너스포인트 : %f
                9. 핸드폰 : %s
                10. 주소 : %s
                --------------------------------
                """.formatted(getEmpNo(), getEmpName(), getDept(), getJob(), getAge(),getGender(), getSalary(), getBonusPoint(), getPhone(), getAddress());
        System.out.println(result);
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
