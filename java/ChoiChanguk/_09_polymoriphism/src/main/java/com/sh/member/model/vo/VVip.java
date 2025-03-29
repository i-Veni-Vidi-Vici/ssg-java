package com.sh.member.model.vo;

public class VVip extends Member implements Buyable{
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double eJapoint() {
        return this.getPoint()*0.15;
    }
    @Override
    public int buy(int price) {
        return (int)(price*0.85);
    }
}
