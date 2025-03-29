package com.ssg.test.student.model.vo;

public class StudentVO {
    private int grade;
    private int classroom;
    private String name;
    private double height;
    private char gender;

    public StudentVO() {}

    public StudentVO(int grade, int classroom, String name, double height, char gender) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
    }

    public void setGrade(int grade) {this.grade = grade;}
    public int getGrade() {return this.grade;}
    public void setClassroom(int classroom) {this.classroom = classroom;}
    public int getClassroom() {return this.classroom;}
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setHeight(double height) {this.height = height;}
    public double getHeight() {return this.height;}
    public void setGender(char gender) {this.gender = gender;}
    public char getGender() {return this.gender;}

    public void printInformation() {
        System.out.println("학년 : " + getGrade());
        System.out.println("반 : " + getClassroom());
        System.out.println("이름 : " + getName());
        System.out.println("키 : " + getHeight());
        System.out.println("성별 : " + getGender());
    }
}
