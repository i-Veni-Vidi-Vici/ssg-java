package com.ssg.collections.map.member;

import java.util.*;

public class MemberTest {
    private Map<String, Member> map = new HashMap<>();

    public MemberTest() {
        map.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        map.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        map.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        map.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        map.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));
    }

    public static void main(String[] args) {
        MemberTest memberTest = new MemberTest();
        memberTest.test1();
        memberTest.test2();
        memberTest.test3();
        memberTest.test4();
    }



    private void test1() {
        System.out.println("test1");
        System.out.println("==========================================================================");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "이름", "비밀번호", "이름", "나이", "전화번호");
        System.out.println("==========================================================================");
        Collection<Member> members = map.values();
        for(Member member : members) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s\n",
                                member.getUserId(),
                                member.getUserPwd(),
                                member.getUserName(),
                                member.getAge(),
                                member.getPhoneNumber());
        }
        System.out.println("==========================================================================");
        System.out.println();
    }

    public boolean isUserExist(String userId) {
        return map.containsKey(userId);
    }

    public void test2() {
        System.out.println("test2");
        System.out.println(isUserExist("jangbg"));
        System.out.println(isUserExist("sejong"));
        System.out.println();
    }

    private void test3() {
        Member member = map.get("yooon");

        member.setUserPwd("5678");
        member.setUserName("윤동주");
        member.setAge(27);
        member.setPhoneNumber("01034563456");

        System.out.println("test3");
        System.out.println(member);
        System.out.println();
    }

    private void test4() {
        map.remove("sinsa");

        System.out.println("test4");
        Collection<Member> members = map.values();
        for(Member member : members) {
            System.out.println(member);
        }
    }
}
