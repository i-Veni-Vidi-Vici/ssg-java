package com.ohgiraffers.hw3.member.model.vo;

public class Vip extends Member{
    public Vip() {}
    public Vip(String name, String grade, int point) {
        super(name,grade,point);
    }

    @Override
    public double getEjapoint(){
        return getPoint() * 0.1;
    }
}
