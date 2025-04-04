package com.ssg.test3.member.model.vo;

public class Vip {
    private String name;
    private String grade;
    private int point;

    public Vip(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public static double getEjapoint(int point) {
        // vip 등급은 10% 를 곱한값이 이자 포인트
        return point * 0.1;
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
