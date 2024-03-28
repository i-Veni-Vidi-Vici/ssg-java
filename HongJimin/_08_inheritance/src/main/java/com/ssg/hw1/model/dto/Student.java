package com.ssg.hw1.model.dto;

public class Student extends Person{
    private int grade;
    private String major;

    public Student() {
        super();
    }


    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major){
        this.major = major;
    }

    @Override
    public String information() {
        System.out.print( "   " + getName() + "\t" + getAge() + "\t" + getHeight() + "\t"  + getWeight() + "\t" + getGrade() + "\t");
        return getMajor();
    }


}
