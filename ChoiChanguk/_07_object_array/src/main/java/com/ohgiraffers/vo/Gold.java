package com.ssg.emp;

import java.util.Set;

public class Gold {
    private String name;
    private String grade;
    private int point;

    public int getPoint() {
        return point;
    }
    public Gold(String name, String grade, int point){
        this.name=name;
        this.grade=grade;
        this.point=point;
    }

    public void setPoint(int point) {
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

    public double getEjapoint() {
        return this.point*0.05;
    }
}
