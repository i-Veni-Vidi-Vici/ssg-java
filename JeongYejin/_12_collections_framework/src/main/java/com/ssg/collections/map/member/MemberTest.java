package com.ssg.collections.map.member;

import java.util.Map;
import java.util.Set;

public class MemberTest {
    public static void main(String[] args) {
        Member member = new Member();
        member.memberMap.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        member.memberMap.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        member.memberMap.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        member.memberMap.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        member.memberMap.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));

        Set<String> keySet = member.memberMap.keySet();
        System.out.print("""
                ==================================================
                아이디	비밀번호	이름	나이	전화번호
                ==================================================
                """);
        for (String key : keySet) {
            System.out.println(member.memberMap.get(key));
        }
        System.out.println("==================================================");

        MemberTest memberTest = new MemberTest();
        memberTest.test2(member);
        memberTest.test3(member);
        memberTest.test3(member);
        memberTest.test4(member);

        System.out.print("""
                ==================================================
                아이디	비밀번호	이름	나이	전화번호
                ==================================================
                """);
        for (String key : keySet) {
            System.out.println(member.memberMap.get(key));
        }
        System.out.println("==================================================");

    }

    private void test2(Member member) {
        System.out.println(isUserExist(member, "jangbg"));
        System.out.println(isUserExist(member, "sejong"));
    }

    private void test3(Member member) {
        Set<String> keySet = member.memberMap.keySet();
        for(String key : keySet) {
            if ("yooon" == key) {
                member.memberMap.put("yooon", new Member("yooon", "5678", "윤동주", 27, "01034563456"));
            }
        }
    }

    private void test4(Member member) {
        member.memberMap.remove("sinsa");
    }

    private boolean isUserExist(Member member, String userId) {
        Set<String> keySet = member.memberMap.keySet();
        for(String key : keySet) {
            if (userId == key) {
                return true;
            }
        }
        return false;
    }
}
