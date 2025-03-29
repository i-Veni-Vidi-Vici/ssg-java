package com.ssg.oop.member.model.vo;

public class Ruby extends Member{

    public Ruby() {
    }

    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public int buy(int price) {
        return price - (int)(price * 0.3);
    }

    @Override
    public double getEjaPoint() {
        return point * 0.3;
    }
}
