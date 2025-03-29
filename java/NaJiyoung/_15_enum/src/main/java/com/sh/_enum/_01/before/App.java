package com.sh._enum._01.before;

/**
 * <pre>
 * 상수
 * - public static final 키워드로써 상수필드 사용
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // new Member(username:STring, role:String, gender:String)
//        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.GENDER_MALE);
        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.MEMBER_ROLE);
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        // 1. role, gender값을 구분할 수 없다.
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_MALE)); // true
        // 2. 일반 String, int타입으로는 타입안정성을 보장할 수 없다.
        System.out.println(createdMember("lesss", Member.ADMIN_ROLE, Member.MEMBER_ROLE));
        // 3. 상수를 묶어서 반복처리등을 묶을 수 없다.
    }

    public static Member createdMember(String username, String role, String gender) {
//        return new Member(username, role, gender);
        return new Member(username, gender, role);
    }
}
