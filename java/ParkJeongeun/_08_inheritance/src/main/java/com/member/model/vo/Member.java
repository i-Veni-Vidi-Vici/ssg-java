package com.member.model.vo;

public abstract class Member {
    private String name;
    private String grade;
    private int point;

    public Member(){}

    public Member(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public abstract double getEjaPoint();

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
