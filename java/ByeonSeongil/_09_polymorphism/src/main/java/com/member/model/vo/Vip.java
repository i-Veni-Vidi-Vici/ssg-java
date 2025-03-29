package com.member.model.vo;

public class Vip extends Member{

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return getPoint()* 0.1;
    }

    @Override
    public int buy(int price) {
        return (int)(price * (1-0.1));
    }
}
