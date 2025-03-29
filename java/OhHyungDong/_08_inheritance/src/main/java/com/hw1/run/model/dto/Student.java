package com.hw1.run.model.dto;

public class Student extends  Person{
    private int grade;
    private String major;

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(name, age, height, weight);
        this.grade = grade;
        this.major = major;
    }

    public Student() {
    }

    public String information(){
        String information= """
        저장된 학생 정보들을 출력합니다. 
        이름  나이     신장    몸무게   학년    전공
        =============================================
        """;
        return information;
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
