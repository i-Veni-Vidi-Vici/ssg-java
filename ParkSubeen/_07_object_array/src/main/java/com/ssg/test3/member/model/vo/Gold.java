package com.ssg.test3.member.model.vo;

public class Gold {
    private String name;
    private String grade;
    private int point;

    public Gold(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public static double getEjapoint(int point) {
        // Gold 등급은 5% 를 곱한값이 이자 포인트
        double gEjaPoint = point * 0.02;
        return gEjaPoint;
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
