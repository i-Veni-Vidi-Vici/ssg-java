package com.hw1.model.dto;

public class Student extends Person{
    private int grade; // 학년

    private String major; // 전공

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.name=name;
        this.grade = grade;
        this.major = major;
    }

    public String information() {

        return super.name+", "+super.getAge()+", "+super.getHeight()+", "+super.getWeight()+", "+grade+", "+major;
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

    public void setMajor(String major) {
        this.major = major;
    }

}
