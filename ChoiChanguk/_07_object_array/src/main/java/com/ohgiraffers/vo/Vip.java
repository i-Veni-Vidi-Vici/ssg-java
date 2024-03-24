package com.ohgiraffers.vo;

public class Vip extends Member{

    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.point*0.1;
    }
}
