package com.member.model.vo;

public class Ruby extends Member{

    public Ruby(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return getPoint() * 0.3;
    }

    @Override
    public int buy(int price){
        return price-(int)(price*0.3);
    }
}
