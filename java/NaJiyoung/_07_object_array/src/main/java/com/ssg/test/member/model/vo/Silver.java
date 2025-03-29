package com.ssg.test.member.model.vo;

public class Silver {
    private String name;    // 이름
    private String grade;   // 등급
    private int point;  // 포인트

    public Silver(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public double getEjapoint() {
        return this.point * 0.02;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setGrade(String grade) {this.grade = grade;}
    public String getGrade() {return this.grade;}
    public void setPoint(int point) {this.point = point;}
    public int getPoint() {return this.point;}
}