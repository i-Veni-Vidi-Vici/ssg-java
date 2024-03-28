package com.hw1.run;

public class Employee extends Person{
    private int salary; // 급여
    private String dept; // 부서

    Person person = new Person();

    public Employee() {}
    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        person.setName(name);
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String information(){
        return person.getName() + "  " + super.information() + "  " + salary + "  " + dept ;
    }
}
