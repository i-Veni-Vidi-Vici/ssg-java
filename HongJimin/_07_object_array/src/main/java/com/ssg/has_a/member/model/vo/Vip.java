package com.ssg.has_a.member.model.vo;

public class Vip extends Member implements Buyable {

    public Vip() {
    }

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.1;
    }

    @Override
    public int buy(int price){
        return (int) (price * 0.1);
    };
}
