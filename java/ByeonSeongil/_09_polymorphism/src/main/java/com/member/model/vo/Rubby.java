package com.member.model.vo;

public class Rubby extends Member{
    public Rubby(String name, String grade, int point) {
        super(name, grade, point);
    }
    @Override
    public double getEjapoint() {
        return getPoint()* 0.3;
    }

    @Override
    public int buy(int price) {
        return (int)(price * (1-0.3));
    }

}
