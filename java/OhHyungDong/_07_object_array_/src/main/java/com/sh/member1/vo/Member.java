package com.sh.member1.vo;

public class Member
{
    private String name;
    private String grade;
    private int point;

    public double getEjaPoint(){
        return 0;
    }
    public Member(String name, String grade, int point) {
        this.name = name;
        this.grade = grade;
        this.point = point;
    }

    public Member() {
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
