package com.sh.member1.vo;

public class Silver extends Member {


    public Silver() {
    }

    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjaPoint(){

        return getPoint() * 0.02;
    }


}
