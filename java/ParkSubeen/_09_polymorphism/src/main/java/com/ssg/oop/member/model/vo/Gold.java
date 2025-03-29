package com.ssg.oop.member.model.vo;

public class Gold extends Member {
    public Gold() {
    }

    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint() {
        return point * 0.05;
    }

    @Override
    public int buy(int price) {
        return price - (int)(price * 0.05);
    }
}
