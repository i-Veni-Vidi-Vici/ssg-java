package com.ohgiraffers.hw1;

public class EmployeeDTO {
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

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empNo, String empName, int age, char gender, String phone, String address) {
        this.empNo = empNo;
        this.empName = empName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public EmployeeDTO(int empNo, String empName, String dept, String job, int age, char gender, int salary, double bonusPoint, String phone, String address) {
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




    public void information(){
        System.out.println("emp"+"["+empNo+"] : " +empNo + empName + dept + job + age + gender + salary+bonusPoint+phone+address);

    }
    int per=0;
    public void money(){
        if(salary==0)
        {

        }
        else{
            per++;
            System.out.printf("%s의 연봉 : %f원\n",empName, ((bonusPoint*salary)+salary)*12);

        }


    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double avg() {
        int sal=0;
        int i=0;
        while(i!=per){
            sal += getSalary();
            i++;
        }

        return sal;  // 연봉의 총합을 사원 수로 나누어 평균 연봉 계산
    }

}
