package com.ssg.has_a.member.model.vo;

import java.io.Serializable;

public class Gold extends Member implements Buyable {
    public Gold() {
    }

    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.05;
    }

    @Override
    public int buy(int price){
        return (int) (price * 0.05);
    };
}
