package com.sh.member.model.vo;

public class Ruby extends Member implements Buyable{
    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public int buy(int price) {
        return (int)(price*0.7);
    }

    @Override
    public double eJapoint() {
        return this.getPoint()*0.3;
    }
}
