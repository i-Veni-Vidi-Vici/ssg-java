package com.sh._enum._01.before;

public class App {
    public static void main(String[] args) {
//        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.GENDER_MALE);
//        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);
        Member honggd = new Member("honggd", Member.MEMBER_ROLE, Member.MEMBER_ROLE);   //다른 롤이 들어감
        Member sinsa = new Member("sinsa", Member.ADMIN_ROLE, Member.GENDER_FEMALE);    //그럼에도 불구하고 오류가 나지 않고 구별하기 어려움

        System.out.println(honggd);
        System.out.println(sinsa);

        //1. role, gender 값을 구분할 수 없다.
        System.out.println(Member.MEMBER_ROLE.equals(Member.GENDER_FEMALE));
        //2. 일반 String, int 타입으로는 타입 안정성을 보장할 수 없다.
        System.out.println(createMember("leess", Member.ADMIN_ROLE, Member.MEMBER_ROLE));
        //3. 상수를 묶어 반복처리등을 묶을 수 없다.

    }
    public static Member createMember(String username, String role, String gender){
//        return new Member(username,role,gender);
        return new Member(username, role, role);

    }
}
