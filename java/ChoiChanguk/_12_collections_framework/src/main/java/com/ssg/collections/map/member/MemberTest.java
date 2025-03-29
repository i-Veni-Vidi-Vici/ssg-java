package com.ssg.collections.map.member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberTest {
    public static void main(String[] args) {
        Map<String , Member> list=new HashMap<>();
        list.put("1",new Member("honggd","1234","홍길동",35,"01012341234"));
        test1(list.values());
    }

    private static void test1(Collection<Member> values) {
        System.out.println(values.toString());
    }
}
