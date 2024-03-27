package com.hw1.run;

public class Student extends Person{
    private int grade; // 학년
    private String major; //전공

    Person person = new Person();

    public Student() {
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        person.setName(name);
        this.grade = grade;
        this.major = major;
    }

    @Override
    public String information(){
        return person.getName() + "  " + super.information() + "  " + grade + "  " + major ;
    }
}
