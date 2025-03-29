package com.ssg.member.model.vo;

public class Ruby extends Member {
    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double EjaPoint() {
        return this.getPoint() * 0.3;
    }

    @Override
    public int buy(int price) {
        return (int)(price * 0.3);
    }
}
