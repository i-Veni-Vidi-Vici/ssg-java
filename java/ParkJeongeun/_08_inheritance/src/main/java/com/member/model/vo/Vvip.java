package com.member.model.vo;

public class Vvip extends Member{
    public Vvip(String name, String grade, int point) {
        super(name, grade, point);
    }
    public double getEjaPoint(){
        return super.getPoint() * 0.15;
    }
}