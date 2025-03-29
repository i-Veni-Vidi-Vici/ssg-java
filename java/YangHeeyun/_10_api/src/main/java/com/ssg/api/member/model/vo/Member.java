package com.ssg.api.member.model.vo;

import java.time.LocalDate;
import java.util.StringTokenizer;

public class Member {
    private int memberNo; // 회원번호
    private String memberName; // 이름
    private int height; // 키
    private int weight; // 몸무게
    private LocalDate birth; // 생일

    public String information() {
        return memberNo + " " + memberName + " " + height + " " + weight + " " + birth;
    }

    public Member(int memberNo, String memberName, int height, int weight, LocalDate birth) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.height = height;
        this.weight = weight;
        this.birth = birth;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        memberName = memberName;
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
