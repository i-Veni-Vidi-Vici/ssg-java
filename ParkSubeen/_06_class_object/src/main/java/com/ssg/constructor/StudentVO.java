package com.ssg.constructor;

public class StudentVO {
    // field
    private int grade;
    private int classroom;
    private String name;
    private double height;
    private char gender;

    // method
    public StudentVO() {}
    public StudentVO(int grade, int classroom, String name, double height, char gender) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
    }

    // setter, getter
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getGrade() {
        return this.grade;
    }
    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
    public int getClassroom() {
        return this.classroom;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return this.height;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return this.gender;
    }

    public void printInformation(StudentVO studentVo) {
        System.out.println("학년 : " + grade + "\n반 : " + classroom + "\n이름 : " + name + "\n키 : " + height + "\n성별 : " + gender);
    }
}
