package com.member.model.vo;

public class Gold extends Member{
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }
    public double getEjaPoint(){
        return super.getPoint() * 0.05;
    }
}