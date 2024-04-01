package com.ssg.collections.map.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberTest {
    private Map<String, Member> map;
    public static void main(String[] args) {
        MemberTest membertest = new MemberTest();
        membertest.test1();
        membertest.test2();
        membertest.test3();
        membertest.test4();
    }
    public MemberTest(){
        map = new HashMap<>();
        map.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        map.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        map.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        map.put("yoon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        map.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));
    }

    public void test1(){
        System.out.println("test1....");
        System.out.println("""
                =================================
                아이디 비밀번호 이름 나이 전화번호
                =================================""");
        Set<String> set = map.keySet();
        for(String key : set){
            System.out.println(map.get(key));
        }
        System.out.println("=================================");
    }

    public boolean isUserExist(String userId){
        return map.containsKey(userId);
    }

    public void test2(){
        System.out.println("test2....");
        System.out.println("key값 jangbg 조회 : " + isUserExist("jangbg") );
        System.out.println("key값 sejong 조회 : " + isUserExist("sejong") );
    }

    public void test3(){
        System.out.println("test3....");
        map.replace("yoon", new Member("yoon", "5678", "윤동주", 27, "01034563456" ));
        System.out.println("Id : "+map.get("yoon").getUserId());
        System.out.println("비밀번호 : "+map.get("yoon").getUserPwd());
        System.out.println("이름 : " + map.get("yoon").getUserName());
        System.out.println("나이 : " + map.get("yoon").getAge());
        System.out.println("전화번호 : " + map.get("yoon").getPhoneNumber());
    }

    public void test4(){
        System.out.println("test4.....");
        map.remove("sinsa");
        System.out.println(map);
    }
}
