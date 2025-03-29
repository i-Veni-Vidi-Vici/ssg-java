package com.ssg.api.member;

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

    public String information() {
        DateTimeFormatter userInfo = DateTimeFormatter.ofPattern("yyyyMMdd");
        return "회원번호: " + memberNo +
                ", 이름: " + memberName +
                ", 키: " + height +
                ", 몸무게: " + weight +
                ", 생일: " + birth.format(userInfo);
    }

}
