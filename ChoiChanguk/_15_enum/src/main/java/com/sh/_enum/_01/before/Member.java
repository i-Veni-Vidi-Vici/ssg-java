package com.sh._enum._01.before;

public class Member {
    public static final String MEMBER_ROLE="M";
    public static final String ADMIN_ROLE="A";
    public static final String GENDER_MALE="M";
    public static final String GENDER_FEMALE="F";
    private String userName;
    private String  role;// M,A
    private String gender;//M,F

    public Member() {
    }

    public Member(String userName, String role, String gender) {
        this.userName = userName;
        this.role = role;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
