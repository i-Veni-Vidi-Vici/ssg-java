package com.sh._enum._01.before;

/**
 * <pre>
 *     상수
 *      - public static final 키워드로써 상수필드 사용
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.MEMBER_ROLE);
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 1. role, gender 값을 구분할 수 없다.
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_MALE));
        // 2. 일반 String, int 타입으로는 타입안정성을 보장할 수 없다.
        System.out.println(createMember("less", Member.ADMIN_ROLE, Member.GENDER_MALE));
        // 3. 상수를 묶어서 반복 처리등을 묶을 수 없다.
    }

    public static Member createMember(String username, String role, String gender) {
//        return new Member(username, role, gender);
        return new Member(role, gender, username);
    }
}
