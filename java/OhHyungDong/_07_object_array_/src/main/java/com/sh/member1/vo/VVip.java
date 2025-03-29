package com.sh.member1.vo;

public class VVip extends Member {

    public VVip() {
    }

    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }
    @Override
    public double getEjaPoint(){
        return getPoint() * 0.15;
    }


}
