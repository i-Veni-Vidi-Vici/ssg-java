package com.ssg.member.model;

public class VVip extends Member {
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    public double getEjapoint() {
        return this.getPoint() * 0.15;
    }
}
