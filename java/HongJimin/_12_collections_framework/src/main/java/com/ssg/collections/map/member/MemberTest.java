package com.ssg.collections.map.member;

import java.util.HashMap;
import java.util.Map;

public class MemberTest {
    public static void main(String[] args) {
        Map<String, Member> map = new HashMap<>();
    Member member = new Member();
        map.put("hoggd", new Member("1234", "홍길동", 35, "01012341234"));
        map.put("sinsa", new Member("1234", "신사임당", 50, "01012341234"));
        map.put("leess", new Member("1234", "이순신", 43, "01012341234"));
        map.put("yooon", new Member("1234", "윤봉길", 37, "01012341234"));
        map.put("jangbg", new Member("1234", "장보고", 29, "01012341234"));

        System.out.println("""
                ====================================
                아이디  비밀번호  이름  나이  전화번호
                ====================================
                """);
        System.out.println(map.size());
        System.out.println(map.get("hoggd"));;
    }



}
