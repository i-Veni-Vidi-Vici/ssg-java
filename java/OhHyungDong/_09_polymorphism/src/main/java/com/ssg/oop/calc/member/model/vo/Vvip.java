package com.ssg.oop.calc.member.model.vo;

public class Vvip extends Member{
    public Vvip() {
    }

    public Vvip(String name, String grade, double point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return 0.15;
    }

}
