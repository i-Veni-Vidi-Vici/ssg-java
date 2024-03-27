package com.ssg.api.member.model.vo;

import java.time.LocalDate;

public class Member {
    private int memberNo;
    private String memberName;
    private int height;
    private int weight;
    private LocalDate birth;

    public Member(int memberNo, String memberName, int height, int weight, LocalDate birth) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
    }

    public String information() {
        return this.memberNo + ", " + this.memberName + ", " + this.height + ", " + this.weight + ", " + birth;
    }
}
