package com.ssg.collections.map.member;

import java.util.HashMap;
import java.util.Map;

public class MemberTest {
    Map<String, Member> map = new HashMap<>();

    public MemberTest() {
        map.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        map.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        map.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        map.put("jangbg", new Member("jangbg", "1234", "장보고", 43, "01012341234"));
    }

    public static void main(String[] args) {

        MemberTest memberTest = new MemberTest();
        memberTest.test();
        memberTest.test2();
        memberTest.test3();
        memberTest.test4();
    }

    private void test() {
        System.out.println("==================================================");
        System.out.println("아이디\t비밀번호\t이름\t나이\t전화번호");
        System.out.println("==================================================");

        for (String s : map.keySet()) {
            System.out.println(
                    map.get(s).getUserId() + " " + map.get(s).getUserPwd() + " " + map.get(s).getUserName() + " "
                            + map.get(s).getAge()
                            + " " + map.get(s).getPhoneNumber());
        }
    }

    private boolean isUserExist(String userId) {
        return map.containsKey(userId);
    }

    private void test2() {
        System.out.println(isUserExist("jangbg"));
        System.out.println(isUserExist("sejong"));
    }

    private void test3() {
        map.put("yooon", new Member("yooon", "5678", "윤동주", 27,
                "01034563456"));
    }

    private void test4() {
        map.remove("sinsa");
    }

}
