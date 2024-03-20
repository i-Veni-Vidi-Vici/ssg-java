package com.sh.custom.type;

import java.util.Arrays;

/**
 * 변수 : 하나의 값을 보관하는 공간
 * 배열 : 동일한 자료형 n개의 값을 보관하는 공간
 * 클래스 : 다른 자료형 n개의 값을 보관하는 공간
 */
public class App {
    public static void main(String[] args) {

        // 클래스 사용 전
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구", "볼링", "테니스"};

        //메소드 호출 시 불편
        printMemberInfo(id, pwd, name, age, gender, hobbies);
//        generateMember(); // 메소드 호출 결과 여러 개의 값을 반환 받을 수 없음!

        //사용자 정의 자료형 Member 사용
        Member member = new Member();

        //타입 별 기본값으로 초기화
        System.out.println(member.id); //null
        System.out.println(member.pwd); //null
        System.out.println(member.name); //null
        System.out.println(member.age); //0
        System.out.println(member.gender); // null문자 \u0000
        System.out.println(member.hobbies); //null

        member.id = "user02";
        member.pwd = "pass02";
        member.name = "신사임당";
        member.age = 40;
        member.gender = '여';
        member.hobbies = new String[]{"스쿼시", "클라이밍"};

        System.out.println(member.id); //user02
        System.out.println(member.pwd); //pass02
        System.out.println(member.name); //신사임당
        System.out.println(member.age); //40
        System.out.println(member.gender); // 여
        System.out.println(member.hobbies); //[Ljava.lang.String;@7a81197d / [Ljava.lang.String -> 스트링 1차원 배열을 의미함/ @뒤의 문자는 해쉬코드
        System.out.println(Arrays.toString(member.hobbies)); // [스쿼시, 클라이밍]

        //메소드 호출 시 인자로 전달
        printMemberInfo(member);

        //메소드 반환 값으로 사용하기
        Member member2 = genarateMember();
        printMemberInfo(member2);
    }

    public static Member genarateMember() {
        Member member = new Member();
        member.id = "leess";
        member.pwd = "pass03";
        member.name = "리순신";
        member.age = 33;
        member.gender = '남';
        member.hobbies = new String[] {"농구", "당구"};
        return member;
    }


    public static void printMemberInfo(Member member){
        System.out.println(member.id); //user02
        System.out.println(member.pwd); //pass02
        System.out.println(member.name); //신사임당
        System.out.println(member.age); //40
        System.out.println(member.gender); // 여
        System.out.println(member.hobbies); //[Ljava.lang.String;@7a81197d / [Ljava.lang.String -> 스트링 1차원 배열을 의미함/ @뒤의 문자는 해쉬코드
        System.out.println(Arrays.toString(member.hobbies)); // [스쿼시, 클라이밍]

    }

    private static void printMemberInfo(String id, String pwd, String name, int age, char gender, String[] hobbies) {
    }
}
