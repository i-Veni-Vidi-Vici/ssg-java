package com.ssg.has_a.member.model.vo;

public class Vip extends Member {

    public Vip() {
    }

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.1;
    }
}
