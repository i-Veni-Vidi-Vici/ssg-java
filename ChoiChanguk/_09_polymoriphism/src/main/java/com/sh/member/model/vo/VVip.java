package com.sh.member.model.vo;

public class VVip extends Member{
    public VVip(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double eJapoint() {
        return this.getPoint()*0.15;
    }
}
