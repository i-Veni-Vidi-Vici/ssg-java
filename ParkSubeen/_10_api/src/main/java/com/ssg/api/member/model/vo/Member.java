package com.ssg.api.member.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Member {
    private int memberNo;
    private String memberName;
    private int height;
    private int weight;
    private LocalDate birth;

    public Member() {
    }

    public Member(int memberNo, String memberName, int height, int weight, LocalDate birth) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
    }

    public Member(String[] str) {
        this.memberNo = Integer.parseInt(str[0]);
        this.memberName = str[1];
        this.height = Integer.parseInt(str[2]);
        this.weight = Integer.parseInt(str[3]);
        this.birth = LocalDate.parse(str[4], DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String information() {
        return memberNo + ", " + memberName + ", " + height + ", " + weight + ", " + birth;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
