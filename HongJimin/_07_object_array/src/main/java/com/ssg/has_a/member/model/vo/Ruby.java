package com.ssg.has_a.member.model.vo;

public class Ruby extends Member implements Buyable{

    public Ruby() {
    }

    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.3;
    }

    @Override
    public int buy(int price){
        return (int) (price * 0.);
    };
}
