package com.ssg.inheritance.hw3.member.model.vo;

public class Vip extends Member{
    public Vip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint(int point) {
        // vip 등급은 10% 를 곱한값이 이자 포인트
        return point * 0.1;
    }
}
