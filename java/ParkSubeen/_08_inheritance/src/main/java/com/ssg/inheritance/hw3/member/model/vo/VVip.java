package com.ssg.inheritance.hw3.member.model.vo;

public class VVip extends Member{
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint(int point) {
        // vvip 등급은 15% 를 곱한값이 이자 포인트
        return point * 0.15;
    }
}
