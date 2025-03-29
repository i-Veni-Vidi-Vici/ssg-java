package com.ssg.member.model;

public class Silver extends Member {

    public Silver() {
        super();
    }

    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    public double getEjapoint() {
        return this.getPoint() * 0.02;
    }
}
