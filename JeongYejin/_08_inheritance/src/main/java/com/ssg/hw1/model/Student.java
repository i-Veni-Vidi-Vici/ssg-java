package com.ssg.hw1.model;

public class Student extends Person {
    private int grade;

    private String major;

    public Student() {
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.setName(name);
        this.grade = grade;
        this.major = major;
    }

    public String information() {
        String str = "%s  %d   %.1f   %.1f    %d  %s".formatted(this.getName(), this.getAge(), this.getHeight(), this.getWeight(), this.grade, this.major);
        return str;
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
