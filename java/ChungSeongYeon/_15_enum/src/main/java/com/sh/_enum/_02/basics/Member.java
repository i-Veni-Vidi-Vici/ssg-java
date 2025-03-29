package com.sh._enum._02.basics;

public class Member {
    private String username;
    private MemberRole role;
    private Gender gender;

    public Member() {
    }

    public Member(String username, MemberRole role, Gender gender) {
        this.username = username;
        this.role = role;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }

}
