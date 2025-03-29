package com.sh._enum._01.before;

/**
 * <pre>
 *
 *
 *
 * </pre>
 */



public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", Member.MEMBER_ROLE,Member.GENDER_MALE);
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE,Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 1. role, gender값을 구분할 수 없다.
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_MALE));
        System.out.println(createMember("leess",Member.ADMIN_ROLE,Member.MEMBER_ROLE));
    }

    public static Member createMember(String username, String role, String gender) {
//        return new Member(username,role, gender);
        return new Member(username,gender,role);
    }
}
