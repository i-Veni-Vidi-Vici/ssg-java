package com.ssg.member.model;

public class Vip extends Member {

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    public double getEjapoint() {
        return this.getPoint() * 0.1;
    }
}
