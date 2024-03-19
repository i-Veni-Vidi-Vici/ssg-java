package com.ssg.oop.emp.model.vo;

import java.util.Scanner;

public class Employee {
    private int empNo;
    private String empName;
    private String dept;
    private String job;
    private int age;
    private char gender;
    public String gen;
    private int salary;
    private double bounuspoint;
    private String phone;
    private String address;

    boolean inIn ;//기본 값 false

//    public Employee(int empNo, String empName, String dept, String job, int age, char gender,
//                    int salary, double bonuspoin, String phone, String address)
//    {
//        this.empNo = empNo;
//        this.empName = empName;
//        this.dept = dept;
//        this.job = job;
//        this.age = age;
//        this.gender = gender;
//        this.salary = salary;
//        this.bounuspoint = bonuspoin;
//        this.phone = phone;
//        this.address = address;
//    }
public void empRemove(Employee employee) {
    if (inIn) {
        // 객체의 상태를 초기화하여 삭제된 상태를 표시
        this.empNo = 0;
        this.empName = null;
        this.dept = null;
        this.job = null;
        this.age = 0;
        this.gender = '\0';
        this.salary = 0;
        this.bounuspoint = 0.0;
        this.phone = null;
        this.address = null;
        this.inIn = false; // 객체의 상태를 초기화하여 삭제된 상태를 표시
        System.out.println("사원 정보가 삭제되었습니다.");
    } else {
        System.out.println("삭제할 사원 정보가 없습니다.");
    }
}

    //값 입력
    public void empInput(Employee employee){

        //값이 없으면
        if(!inIn){
            this.inIn = true;
            Scanner scanner = new Scanner(System.in);
            System.out.print("사번 : "); employee.empNo = scanner.nextInt();
            System.out.print("이름 : "); employee.empName = scanner.next();
            System.out.print("소속부서 : "); employee.dept = scanner.next();
            System.out.print("직급 : "); employee.job = scanner.next();
            System.out.print("나이 : "); employee.age = scanner.nextInt();
            System.out.print("성별 : "); employee.gen = scanner.next();
            gender = gen.charAt(0);
            System.out.print("급여 : "); employee.salary = scanner.nextInt();
            System.out.print("보너스포인트 : "); employee.bounuspoint = scanner.nextDouble();
            System.out.print("핸드폰 : "); employee.phone = scanner.next();
            System.out.print("주소 : "); employee.address = scanner.next();
        }


    }

    public void empOutput(Employee employee){

        if(inIn)
        {
            System.out.println("사번 : " + employee.empNo );
            System.out.println("이름 : " + employee.empName);
            System.out.println("소속부서 : " + employee.dept);
            System.out.println("직급 : " + employee.job);
            System.out.println("나이 : " + employee.age);
            System.out.println("성별 : " + employee.gender);
            System.out.println("급여 : " + employee.salary);
            System.out.println("보너스포인트 : " + employee.bounuspoint);
            System.out.println("핸드폰 : " + employee.phone);
            System.out.println("주소 : " + employee.address);
        }
        else{
            System.out.println("안에 정보가 없습니다.");
        }

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

    public double getBounuspoint() {
        return bounuspoint;
    }

    public void setBounuspoint(double bounuspoint) {
        this.bounuspoint = bounuspoint;
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
