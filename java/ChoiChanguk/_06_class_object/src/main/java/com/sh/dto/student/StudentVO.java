package com.sh.dto.student;

public class StudentVO {
    private int grade;

    private int classroom;
    private String name;
    private double height;
    private char gender;
    StudentVO(){}

    StudentVO(int grade, int classroom, String name, double height, char gender)
    {
        this.grade=grade;
        this.classroom=classroom;
        this.name=name;
        this.height=height;
        this.gender=gender;
    }
    public void printInformation()
    {
        System.out.print("학년 : "+getGrade()+" \n");
        System.out.print("반 : "+getClassroom()+" \n");
        System.out.print("이름 : "+getName()+" \n");
        System.out.print("키 : "+getHeight()+" \n");
        System.out.print("성별 : "+getGender()+" \n");


    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassroom() {
        return this.classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
