package com.member.model.vo;

public class Vip extends Member{
    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }
    public double getEjaPoint(){
        return super.getPoint() * 0.1;
    }
}