package com.sh._enum._03.advanced;

public enum UserRole {
    USER("사용자"),
    ADMIN("관리자"),
    SUPER_ADMIN("슈퍼관리자");

    private final String desc;

    UserRole(String desc) {
        this.desc = desc;
    }

    public static UserRole of(String desc) { // Method 'valueOf(java.lang.String)' is never used
        return switch (desc) {
            case "사용자" -> USER;
            case "관리자" -> ADMIN;
            case "슈퍼관리자" -> SUPER_ADMIN;
            default -> throw new IllegalArgumentException("존재하지 않는 desc입니다. : " + desc);
        };
    }

    public String getDesc() {
        return this.desc;
    }
}
