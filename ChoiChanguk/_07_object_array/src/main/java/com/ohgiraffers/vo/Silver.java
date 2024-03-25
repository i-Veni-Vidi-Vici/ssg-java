package com.ohgiraffers.vo;

public class Silver extends Member {

    public Silver(String name, String grade, int point){
        super(name, grade, point);

    }

    @Override
    public double getEjapoint() {
        return this.point*0.05;
    }
}
