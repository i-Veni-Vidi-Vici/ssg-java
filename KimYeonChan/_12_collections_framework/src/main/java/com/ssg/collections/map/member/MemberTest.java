package com.ssg.collections.map.member;

import java.util.HashMap;
import java.util.Map;

public class MemberTest {
    private static Map<String, Member> members = new HashMap<>();
    public static void main(String[] args) {
        members.put("honggd", new Member("honggd", "1234", "홍길동", 35, "01012341234"));
        members.put("sinsa", new Member("sinsa", "1234", "신사임당", 50, "01012341234"));
        members.put("leess", new Member("leess", "1234", "이순신", 43, "01012341234"));
        members.put("yooon", new Member("yooon", "1234", "윤봉길", 37, "01012341234"));
        members.put("jangbg", new Member("jangbg", "1234", "장보고", 29, "01012341234"));

        MemberTest app = new MemberTest();
        // 1. 회원 정보를 저장 후 출력하세요.
        app.test1();
        // 2. 저장된 회원 중 인자로 전달한 아이디가 존재하는 여부를 검사하는 메소드를 생성하시오.
        System.out.println(app.isUserExist("jangbg"));
        System.out.println(app.isUserExist("sejong"));
        // 3. yoon 아이디 조회 후 해당 객체를 다음과 같이 수정하세요.
        app.test3();
        // 4. sinsa 아이디 회원 삭제
        app.test4();
        app.test1();
    }

    public void test1() {
        System.out.println("====================");
        System.out.println("아이디  비밀번호  이름  나이  전화번호");
        System.out.println("====================");
        for (Member member : members.values()) {
            System.out.printf("%s  %s  %s  %d  %s\n", member.getUserId(), member.getUserPwd(), member.getUserName(), member.getAge(), member.getPhoneNumber());
        }
        System.out.println("====================");
    }

    public boolean isUserExist(String userId) {
        return members.containsKey(userId);
    }

    public void test3() {
        members.put("yooon", new Member("yooon", "5678", "윤동주", 27, "01034563456"));
    }

    public void  test4() {
        members.remove("sinsa");
    }
}
