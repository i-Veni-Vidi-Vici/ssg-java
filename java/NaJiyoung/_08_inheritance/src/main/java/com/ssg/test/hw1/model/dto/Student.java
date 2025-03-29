package com.ssg.test.hw1.model.dto;

public class Student extends Person {
    private int grade;  // 학년
    private String major;   // 전공

    public Student() {}
    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        this.name = name;
        this.grade = grade;
        this.major = major;
    }
    public void setGrade(int grade) { this.grade = grade; }
    public int getGrade() {return this.grade; }
    public void setMajor(String major) { this.major = major; }
    public String getMajor() {return this.major; }

    @Override
    public String information() {
        return "학생 정보: " + super.information() + ", grade = " + grade + ", major = " + major;
    }
}
