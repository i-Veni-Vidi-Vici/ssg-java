package com.ssg.test.hw1.model.dto;

public class Employee extends Person {
    private int salary; // 급여
    private String dept;    // 부서

    public Employee() {}
    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
    public void setSalary(int salary) { this.salary = salary; }
    public int getSalary() { return this.salary; }
    public void setDept(String dept) { this.dept = dept; }
    public String getDept() { return this.dept; }

    @Override
    public String information() {
        return "사원 정보: " + super.information() + ", salary = " + salary + ", dept = " + dept;
    }
}
