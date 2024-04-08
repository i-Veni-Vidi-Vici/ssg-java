package com.sh._enum._01.before;

public class Member {
    public static final String MEMBER_ROLE = "M";
    public static final String ADMIN_ROLE = "A";
    public static final String GENDER_MALE = "M";
    public static final String GENDER_FEMALE = "F";

    private String username;
    private String role;    //M A
    private String gender;  //M F

    public Member(){
    }

    public Member(String username, String role, String gender) {
        this.username = username;
        this.role = role;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("{username = %s , role = %s, gender = %s}", username, role, gender);
    }
}
