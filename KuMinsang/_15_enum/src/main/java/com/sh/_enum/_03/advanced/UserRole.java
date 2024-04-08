package com.sh._enum._03.advanced;

public enum UserRole {
    USER("사용자"),
    ADMIN("관리자"),
    SUPER_ADMIN("슈퍼관리자");

    private final String desc;

    UserRole(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }

    public static UserRole of(String desc){
        return switch(desc){
            case "사용자" -> USER;
            case "관리자" -> ADMIN;
            case "슈퍼관리자" -> SUPER_ADMIN;
            default -> throw new IllegalArgumentException("존재하지 않는 코드입니다" + desc);
        };
    }
}
