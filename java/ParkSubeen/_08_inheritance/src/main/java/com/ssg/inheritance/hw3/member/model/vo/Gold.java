package com.ssg.inheritance.hw3.member.model.vo;

public class Gold extends Member{
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    public double getEjapoint(int point) {
        // Gold 등급은 5% 를 곱한값이 이자 포인트
        return point * 0.02;
    }
}
