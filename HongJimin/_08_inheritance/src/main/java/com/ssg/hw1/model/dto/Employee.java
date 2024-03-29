package com.ssg.hw1.model.dto;

public class Employee extends Person{
    private int salary;
    private String dept;

    public Employee() {
        super();
    }


    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept(){
        return dept;
    }

    public void setDept(String dept){
        this.dept = dept;
    }

    @Override
    public String information() {
        System.out.print( "   " + getName() + "\t" + getAge() + "\t" + getHeight() + "\t"  + getWeight() + "\t" + getSalary() + "\t");
        return getDept();
    }
}
