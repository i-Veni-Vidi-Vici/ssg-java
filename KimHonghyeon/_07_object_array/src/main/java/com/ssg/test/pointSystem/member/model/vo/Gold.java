package com.ssg.test.pointSystem.member.model.vo;

public class Gold {
    String name;
    String grade = "Gold";
    int point;

    public Gold(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
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
    public int getEjaPoint(){
        return this.point*
    }
}
