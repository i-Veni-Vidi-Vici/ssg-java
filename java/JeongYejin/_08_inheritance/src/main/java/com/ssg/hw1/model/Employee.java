package com.ssg.hw1.model;

public class Employee extends Person {
    private int salary;
    private String dept;

    public Employee() {
    }

    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.setName(name);
        this.salary = salary;
        this.dept = dept;
    }

    public String information() {
        String str = "%s  %d   %.1f   %.1f    %d  %s".formatted(this.getName(), this.getAge(), this.getHeight(), this.getWeight(), this.salary, this.dept);
        return str;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
