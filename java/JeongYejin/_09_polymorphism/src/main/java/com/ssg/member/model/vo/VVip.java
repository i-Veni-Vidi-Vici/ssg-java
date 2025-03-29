package com.ssg.member.model.vo;

public class VVip extends Member {
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }
    @Override
    public double EjaPoint() {
        return getPoint() * 0.15;
    }

    @Override
    public int buy(int price) {
        return (int)(price * 0.15);
    }
}
