package com.ssg.has_a.member.model.vo;

import com.sh._03.has.a.Person;

public class Silver extends Member {

    public Silver() {
    }

    public Silver(String name, String grade, int point) {
        super(name, grade, point);
    }

    @Override
    public double getEjapoint() {
        return this.getPoint() * 0.02;
    }
}
