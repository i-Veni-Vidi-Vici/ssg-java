package com.sh._enum._02.basics;

public class Member {
    private String username;
    private MemberRole role;
    private Gender gedner;

    public Member() {
    }

    public Member(String username, MemberRole role, Gender gedner) {
        this.username = username;
        this.role = role;
        this.gedner = gedner;
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

    public Gender getGedner() {
        return gedner;
    }

    public void setGedner(Gender gedner) {
        this.gedner = gedner;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", gedner=" + gedner +
                '}';
    }
}
