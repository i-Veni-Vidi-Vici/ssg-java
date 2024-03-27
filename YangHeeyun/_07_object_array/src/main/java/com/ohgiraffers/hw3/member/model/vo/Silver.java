package com.ohgiraffers.hw3.member.model.vo;

public class Silver {
    private String name; // 이름
    private String grade; // 등급
    private int point; // 포인트

    public Silver() {
    }
    public Silver(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public double getEjapoint(){
        return point * 0.02;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
