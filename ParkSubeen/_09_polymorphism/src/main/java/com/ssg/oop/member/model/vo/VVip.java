package com.ssg.oop.member.model.vo;

public class VVip extends Member{
    public VVip() {
    }

    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint() {
        return point * 0.15;
    }

    @Override
    public int buy(int price) {
        return price - (int)(price * 0.15);
    }
}
