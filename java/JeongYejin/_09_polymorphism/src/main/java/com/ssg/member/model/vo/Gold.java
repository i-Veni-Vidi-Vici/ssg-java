package com.ssg.member.model.vo;

public class Gold extends Member {

//    private String name;
//    private String grade;
//    private int point;
    public Gold(String name, String grade, int point) {
        super(name, grade, point);
    }
    @Override
    public double EjaPoint() {
        return getPoint() * 0.05;
    }

    @Override
    public int buy(int price) {
        return (int)(price * 0.05);
    }
}
