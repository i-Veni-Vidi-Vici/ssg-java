package com.sh.member.model.vo;

public class Gold extends Member{
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double eJapoint() {
        return this.getPoint()*0.05;
    }
}
