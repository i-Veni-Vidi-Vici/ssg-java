package com.ssg.member.model;

public class Gold extends Member {

    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    public double getEjapoint() {
        return this.getPoint() * 0.05;
    }
}
