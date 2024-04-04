package com.sh._enum._02.basics;

public class Member {
    private String username;
    private MemberRole role;
    private Gender gender;

    public Member(String username, MemberRole role, Gender gender) {
        this.username = username;
        this.role = role;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("{username = %s , role = %s, gender = %s}", username, role, gender);
    }
}
