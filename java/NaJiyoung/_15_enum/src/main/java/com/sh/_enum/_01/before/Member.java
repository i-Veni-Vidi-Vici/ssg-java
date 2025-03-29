package com.sh._enum._01.before;

public class Member {
    public static final String MEMBER_ROLE = "M";
    public static final String ADMIN_ROLE = "A";
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";
    private String username;
    private String role; // M, A
    private String gender; // M, F

    public Member() {
    }

    public Member(String username, String role, String gender) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
