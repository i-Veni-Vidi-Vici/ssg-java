package com.ssg.member.model.vo;

public class Silver extends Member {
    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double EjaPoint() {
     return getPoint() * 0.02;
    }

    @Override
    public int buy(int price) {
        return (int)(price * 0.02);
    }

}
