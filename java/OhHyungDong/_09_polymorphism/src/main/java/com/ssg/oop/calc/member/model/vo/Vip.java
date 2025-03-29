package com.ssg.oop.calc.member.model.vo;

public class Vip extends Member {
    public Vip() {
    }

    public Vip(String name, String grade, double point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return 0.1;
    }
}
