package com.member.model.vo;

public class Gold extends Member  {

    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return getPoint()* 0.05;
    }

    @Override
    public int buy(int price) {
        return (int)(price * (1-0.05));
    }
}
