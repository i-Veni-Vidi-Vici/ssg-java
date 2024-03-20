package com.sh.custom.type;

import java.util.Arrays;

/**
 * 변수: 하나의 값을 보관하는 공간
 * 배열: 동일한 자료형 n개의 값을 보관하는 공간
 * 클래스: 다른 자료형 n개의 값을 보관하는 공간
 */
public class App {
    public static void main(String[] args) {
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[] {"축구", "볼링", "테니스"};
        // 메소드 호출 시 불편
        // printMemverInfo(id, pwd, name, age, gender, hobbies);
        // generateMember(); // 메소드 호출 결과 여러개의 값을 반환받을 수 없다.

        // 사용자 정의 자료형 Member 사용
        Member member = new Member();
        // 타입별 기본값으로 초기화
        System.out.println(member.id); // null
        System.out.println(member.pwd); // null
        System.out.println(member.name); // null
        System.out.println(member.age); // 0
        System.out.println(member.gender);// null 문자 \u0000
        System.out.println(member.hobbies); // null

        member.id = "user02";
        member.pwd = "pass02";
        member.name = "김연찬";
        member.age = 27;
        member.gender = '남';
        member.hobbies = new String[]{"수영", "클라이밍", "레슬링"};

        System.out.println(member.id); // user02
        System.out.println(member.pwd); // pass02
        System.out.println(member.name); // 김연찬
        System.out.println(member.age); // 27
        System.out.println(member.gender);// ska
        System.out.println(member.hobbies); // [Ljava.lang.String;@251a69d7 -> String[]@hashCode
        System.out.println(Arrays.toString(member.hobbies));

        // 메소드 호출 시 인자로 전달
        printMemberInfo(member);
        // 메소드 반환값으로 사용하기
        Member member2 = new Member();
        member2 = generatorMember();

    }

    public static Member generatorMember() {
        Member member = new Member();
        member.id = "leess";
        member.pwd = "pass03";
        member.name = "리순신";
        member.age = 33;
        member.gender = '남';
        member.hobbies = new String[]{"농구", "당구"};
        return member;
    }

    public static void printMemberInfo(Member member) {
    }
}
