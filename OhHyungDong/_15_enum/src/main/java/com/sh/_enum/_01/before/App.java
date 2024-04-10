package com.sh._enum._01.before;

/**
 * <pre>
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Member honggd = new Member("honggd", Member.Member_ROLE, Member.GENDER_MALE);
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);
        System.out.println(honggd);
        System.out.println(sinsa);

        //1. role, gender 값을 구분할 수 없다.
        System.out.println(Member.Member_ROLE.equals(Member.GENDER_MALE));
        //2. 일반 String, int 타입으로는 타입 안정성을 보장할 수 없다.(적절한 타입인지 구분할 수 없다.)
        System.out.println(createMember("less",Member.ADMIN_ROLE,Member.ADMIN_ROLE));
        //3. 상수를 묶어서 반복처리등을 묶을 수 없다.
    }

    public static Member createMember(String username, String role, String gender){
        return new Member(username, role, gender);
//        return new Member(username, gender, role);
    }
}
