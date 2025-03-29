package com.ssg.has_a.member.model.vo;

public class VVip extends Member implements Buyable{

    public VVip() {
    }

    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.15;
    }

    @Override
    public int buy(int price){
        return (int) (price * 0.15);
    };
}
