package com.ssg.has_a.member.model.vo;

public class Gold extends Member {
    public Gold() {
    }

    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }


    public double getEjapoint() {
        return this.getPoint() * 0.05;
    }
}
