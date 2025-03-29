package com.sh.greedy.level02.normal.student.model.vo;

public class StudentVO {
    private int grade;
    private int classroom;
    private String name;
    private double height;
    private char gender;

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public StudentVO(){

    }
    public StudentVO(int grade, int classroom, String name, double height, char gender){
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
    }

    public void printInformation(){
        System.out.println("학년 : "+this.grade+"\n반 : "+classroom+"\n이름 : "+name+"\n키 : "+height+"\n성별 : "+gender);
    }
}
