package com.sh._enum._01.before;

public class Member {
    public static final String Member_ROLE = "M";
    public static final String ADMIN_ROLE = "A";
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    private String username;
    private String role;
    private String gender;

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Member(){}
    public Member(String username, String role, String gender) {
        this.username = username;
        this.role = role;
        this.gender = gender;
    }
}
