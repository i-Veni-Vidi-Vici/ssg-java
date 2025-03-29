package com.sh._enum._02.basics;

public class Member {
    private String userName;
    private MemberRole role;
    private Gender gender;

    public Member() {
    }

    public Member(String userName, MemberRole role, Gender gender) {
        this.userName = userName;
        this.role = role;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MemberRole getRole() {
        return role;
    }

    public void setRole(MemberRole role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
