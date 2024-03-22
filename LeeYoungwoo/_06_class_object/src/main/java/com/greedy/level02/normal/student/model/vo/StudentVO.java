package com.greedy.level02.normal.student.model.vo;

import java.util.Scanner;

/**
 * `-` private
 * `~` default
 * `#` protected
 * `+` public
 * 밑줄은 static을 의미합니다.
 */
public class StudentVO {
    private int grade;
    private int classroom;
    private String name;
    private double height;
    private char gender;

    Scanner sc = new Scanner(System.in);

    // Constructor
    public StudentVO(){}
    public StudentVO(int grade, int classroom, String name, double height, char gender){
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
    }

    // setters, getters
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

    public void printInformation() {
        System.out.println("학년 : " + getGrade());
        System.out.println("반 : " + getClassroom());
        System.out.println("이름 : " + getName());
        System.out.println("키 : " + getHeight());
        System.out.println("성별 : " + getGender());
    }
}
