package com.ohgiraffers.hw3.member.model.vo;

public class Silver extends Member {
    public Silver() {
    }

    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return getPoint() * 0.02;
    }
}
