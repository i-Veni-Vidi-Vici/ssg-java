package com.ohgiraffers.vo;

import java.util.Set;

public class Gold extends Member {


    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.point*0.05;
    }
}
