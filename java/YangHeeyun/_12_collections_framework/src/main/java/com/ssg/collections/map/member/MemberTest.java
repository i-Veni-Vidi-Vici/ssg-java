package com.ssg.collections.map.member;

import java.util.*;

/**
 * 1. 다음 회원 정보를 `Map<String, Member>`에 저장후, 출력하세요.
 *     1. 회원 Map은 필드로 지정하고, MemberTest 생성자에서 map에 요소 추가할 것.
 *     2. 메소드 `com.ssg.collections.map.member.MemberTest.test1`
 *         - map의 모든 member객체 정보 출력
 *     3. 출력예시
 * ==================================================
 * 아이디	비밀번호	이름	나이	전화번호
 * ==================================================
 * honggd	1234	홍길동	35	01012341234
 * sinsa	1234	신사임당	50	01012341234
 * leess	1234	이순신	43	01012341234
 * yooon	1234	윤봉길	37	01012341234
 * jangbg	1234	장보고	29	01012341234
 * ==================================================
 */

public class MemberTest {
    Map<String,Member> memberMap = new HashMap<>();

    public MemberTest(){
        memberMap.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        memberMap.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        memberMap.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        memberMap.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        memberMap.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));
    }

    public static void main(String[] args) {
        MemberTest memberTest = new MemberTest();
        memberTest.test1();
        memberTest.test2();
        memberTest.test3();
        memberTest.test4();
    }

    public void test1(){
            System.out.println("==================================================");
            System.out.println("아이디\t비밀번호\t이름\t\t나이\t전화번호");

            // Map 반복문 KeySet방법
            Set<String> keySet = memberMap.keySet();
            for(String key: keySet){
                Member value = memberMap.get(key);
                System.out.println(value.getUserId() + "\t" + value.getUserPwd() + "\t" + value.getUserName() + "\t" +
                        value.getAge() + "\t" + value.getPhoneNumber());
            }
            System.out.println("==================================================");
    }

    public boolean isUserExist(String userId){
        return memberMap.containsKey(userId);
    }

    public void test2(){
        System.out.println(isUserExist("jangbg"));
        System.out.println(isUserExist("sejong"));
    }

    public void test3(){
        System.out.println(memberMap.get("yooon"));
        memberMap.put("yooon", new Member("yooon","1234","윤동주",27,"01034563456"));
    }

    public void test4(){
        memberMap.remove("sinsa");
    }
}