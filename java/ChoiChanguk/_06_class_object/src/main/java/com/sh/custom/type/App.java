package com.sh.custom.type;

import java.util.Arrays;

/**
 * <pre>
 * - 변수 하나의 값을 보관하는 공간
 * - 배열 동일한 자료형 n개의 값을 보관하는 공간
 * ?? 다른 자료형 n개의 값을 보관하는 공간 = 클래스다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구","볼링","테니스"};
        // gerateMember(); 메소드 호출결과 여러개의 값을 반환받지 못한다.

        //사용자 정의 자료형 Member사용
        Member member=new Member();
        member.id = "user01";
        member.pwd = "pass01";
        member.name = "신사임당";
        member.age=40;
        member.gender = '여';
        member.hobbies = new String[]{"스쿼시","클라이밍"};
        System.out.println(member.id);
        System.out.println(member.pwd);
        System.out.println(member.name);
        System.out.println(member.gender);
        System.out.println(Arrays.toString(member.hobbies));

        //메소드 호출시 인자로 전달
        //App app=new App(); static이 아닌경우
        printMemberInfor(member);
        //메소드 반환값으로 사용하기
        Member member2=generateMember();
        printMemberInfor(member2);
    }
    public static void printMemberInfor(Member member)
    {
        System.out.println(member.id);
        System.out.println(member.pwd);
        System.out.println(member.name);
        System.out.println(member.gender);
        System.out.println(Arrays.toString(member.hobbies));
    }
    public static Member generateMember()
    {
        Member member=new Member();
        member.id = "leess";
        member.pwd = "pass03";
        member.name = "이순신";
        member.age=33;
        member.gender = '남';
        member.hobbies = new String[]{"가야금","장구"};
        return member;
    }
}
