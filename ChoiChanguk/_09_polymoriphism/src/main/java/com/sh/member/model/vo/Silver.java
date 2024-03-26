package com.sh.member.model.vo;

public class Silver extends Member implements Buyable{
    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double eJapoint() {
        return this.getPoint()*0.02;
    }

    @Override
    public int buy(int price) {
        return (int)(price*0.98);
    }
}
