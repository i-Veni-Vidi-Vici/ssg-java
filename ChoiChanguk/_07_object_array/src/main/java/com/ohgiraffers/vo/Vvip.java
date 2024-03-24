package com.ohgiraffers.vo;

public class Vvip extends Member{
    public Vvip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.point * 0.15;
    }
}
