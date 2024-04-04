package com.ssg.collections.map.member;

import java.util.HashMap;
import java.util.Map;

public class MemberTest {
    private Map<String, Member> memberMap = new HashMap<>();

    public static void main(String[] args) {
        MemberTest memberTest = new MemberTest();
        memberTest.test1();
        memberTest.test2();
        memberTest.test3();
        memberTest.test4();
    }

    public MemberTest() {
        memberMap.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        memberMap.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        memberMap.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        memberMap.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        memberMap.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));
    }

    public void test1() {
        System.out.println(memberMap);
    }

    public boolean isUserExist(String userId) {
        if(memberMap.get(userId) == null) // userId의 key를 가진 memberMap이 없는 경우
            return false;
        // userId - memberMap의 userId를 가진 key의 member객체의 userId 비교
        return userId.equals(memberMap.get(userId).getUserId());

//        return memberMap.containsKey(userId); // userId - memberMap의 userId를 가진 key 비교
    }

    public void test2() {
        System.out.println(isUserExist("jangbg"));
        System.out.println(isUserExist("sejong"));
    }

    public void test3() {
        Member yooon = memberMap.get("yooon");
        System.out.println("yooon = " + yooon);
        yooon.setUserPwd("1234");
        yooon.setUserName("윤동주");
        yooon.setAge(27);
        yooon.setPhoneNumber("01034563456");
        System.out.println("yooon = " + yooon);
    }

    public void test4() {
        memberMap.remove("sinsa");
        System.out.println(memberMap);
    }
}
