package com.sh.member1.vo;

public class Vip extends Member{
    public Vip() {
    }

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint(){
        return getPoint() * 0.10;
    }


}
