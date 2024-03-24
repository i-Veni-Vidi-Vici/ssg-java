package com.sh.member1.vo;

public class Gold extends Member{


    public Gold(){

    }
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint(){

        return getPoint() * 0.05;
    }


}
