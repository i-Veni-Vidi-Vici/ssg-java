package com.sh.custom.type;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //클래스 사용전
        String id = "user01";
        String pwd = "pass01";
        String name = "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies =new String[]{"축구","볼링","테니스"};
        //메소드 호출시 불편
        printMemberInfo(id,pwd,name,age,gender,hobbies);
        // generateMember();//메소드 호출결과 여러개의 값을 반환받을 수 없다.
        Member member = new Member();
        System.out.println(member.id);
        System.out.println(member.pwd);
        System.out.println(member.name);
        System.out.println(member.age);
        System.out.println(member.gender);
        System.out.println(member.hobbies);
        member.id="user02";
        member.pwd="pass02";
        member.name="신사임당";
        member.age=40;
        member.gender='여';
        member.hobbies=new String[]{"수영","클라이밍"};
        System.out.println(member.id);
        System.out.println(member.pwd);
        System.out.println(member.name);
        System.out.println(member.age);
        System.out.println(member.gender);
        System.out.println(member.hobbies);
        System.out.println(Arrays.toString(member.hobbies));
        //메소드 호출시 인자로 전달
        printMemberInfo(member);
        Member member2 = generateMember();
        printMemberInfo(member2);
    }
    public static Member generateMember(){
        Member member = new Member();
        member.id = "leess";
        member.pwd="pass03";
        member.name="리순신";
        member.age=33;
        member.gender='남';
        member.hobbies=new String[]{"당구","농구"};
        return member;
    }
    public static void printMemberInfo(Member member){

    }

    private static void printMemberInfo(String id, String pwd, String name, int age, char gender, String[] hobbies) {
    }
}
