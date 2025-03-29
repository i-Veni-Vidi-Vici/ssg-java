package com.ssg.test.classObject.problem2;

public class StudentVo {
    int grade, classroom;
    String name;
    double height;
    char gender;
    public StudentVo(){}
    public StudentVo(int grade, int classroom, String name, double height, char gender) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;
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

    public void printInformation(){
        System.out.printf("학년: %d 반: %d 이름: %s 키: %f 성별: %c", this.grade, this.classroom, this.name, this.height, this.gender);
    }
}
