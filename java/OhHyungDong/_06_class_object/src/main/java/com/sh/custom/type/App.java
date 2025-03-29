package com.sh.custom.type;

import java.util.Arrays;

/**
 * - 변수 : 하나의 값을 보관하는 공간
 * - 배열 : 동일한 자료형 n개의 값을 보관하는 공간
 * - 클래스 : 다른 자료형 n개의 값을 보관하는 공간
 */
public class App {

    public static void main(String[] args) {
        //클래스 사용전
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구", "볼링", "테니스"};

        //메소드 호출시 불편
//        printMemberInfor(id,pwd,name,age,gender,hobbies);
        // generatemember(); //메소드 호출결과 여러개의 값을 반환 받을 수 없다.

        //사용자 정의 자료형 Member사용
        Member member = new Member();
        //타입별 기본 값으로 초기화
        System.out.println(member.id);//null
        System.out.println(member.pwd);//null
        System.out.println(member.name);//null
        System.out.println(member.age);//0
        System.out.println(member.gender);//null문자 \u0000
        System.out.println(member.hobbies);//null

        member.id = "user02";
        member.pwd = "pass02";
        member.name = "신사임당";
        member.age = 40;
        member.gender = '여';
        member.hobbies = new String[]{"스쿼시", "클라이밍"};

        System.out.println(member.id);//null
        System.out.println(member.pwd);//null
        System.out.println(member.name);//null
        System.out.println(member.age);//0
        System.out.println(member.gender);//null문자 \u0000
        System.out.println(member.hobbies);//null Ljava.lang.String;@251a69d7 -> 위치값 @~ hashcode값
        System.out.println(Arrays.toString(member.hobbies));

        //메소드 호출시 인자로 전달
        printMemberInfor(member);
        //메소드 반환값으로 사용하기
        Member member2 = generateMember(); // generateMember에 반환값인 참조값을 member2에 대입
        printMemberInfor(member2);
    }

    private static Member generateMember() {
        Member member = new Member();
        member.id = "lesses";
        member.pwd = "pass03";
        member.name = "이순신";
        member.age = 33;
        member.gender = '남';
        member.hobbies = new String[]{"농구", "당구"};
        return member;

        //인덱스로 접근하는게 아닌 -> id, pwd, name, age, gender, hobbies 등 이름으로 접근한다.
    }

    private static void printMemberInfor(Member member)
    {
        System.out.println(member.id);//null
        System.out.println(member.pwd);//null
        System.out.println(member.name);//null
        System.out.println(member.age);//0
        System.out.println(member.gender);//null문자 \u0000
        System.out.println(member.hobbies);//null Ljava.lang.String;@251a69d7 -> 위치값 @~ hashcode값
        System.out.println(Arrays.toString(member.hobbies));
    }
}
