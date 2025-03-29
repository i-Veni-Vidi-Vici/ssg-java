package com.ssg.test.normal.student.model.vo;

import java.util.Scanner;

public class StudentVO {
    int grade;
    int classroom;
    String name;
    double height;
    char gender;

    StudentVO(){}
    StudentVO(int grade, int classroom, String name, double height, char gender){
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
    }

    void printInformation(){
        String result = """
                학년 : %d
                반 : %d
                이름 : %s
                키 : %.1f
                성별 : %s
                """.formatted(this.grade, this.classroom, this.name, this.height, this.gender);
        System.out.println(result);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
