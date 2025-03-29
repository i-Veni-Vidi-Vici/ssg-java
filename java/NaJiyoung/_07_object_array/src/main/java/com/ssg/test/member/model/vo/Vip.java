package com.ssg.test.member.model.vo;

public class Vip {
    private String name;
    private String grade;
    private int point;

    public Vip(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public double getEjapoint() {
        return this.point * 0.1;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setGrade(String grade) {this.grade = grade;}
    public String getGrade() {return this.grade;}
    public void setPoint(int point) {this.point = point;}
    public int getPoint() {return this.point;}
}
