package com.ssg.inheritance.hw3.member.model.vo;

public class Silver extends Member{
    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint(int point) {
        // Silver 등급은 2% 를 곱한값이 이자 포인트
        return point * 0.02;
    }
}
