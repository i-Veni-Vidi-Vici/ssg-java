package com.hw1.model.dto;

public class Employee extends Person{
    private String name;
    private int salary;
    private String dept;

    public Employee() {
    }

    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + super.getAge() +
                ", height=" + super.getHeight() +
                ", weight=" + super.getWeight() +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public String information(){
        String result = """
                이름   나이   신장   몸무게    급여     부서
                %s    %d   %.1f    %.1f     %d      %s
                """.formatted(name, getAge(), getHeight(), getWeight(), salary, dept);
        return result;
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
