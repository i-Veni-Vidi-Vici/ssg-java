package com.ssg.oop.calc.member.model.vo;

public class Ruby extends Member {

    public Ruby() {
    }

    public Ruby(String name, String grade, double point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return getPoint() * 0.3;
    }
}
