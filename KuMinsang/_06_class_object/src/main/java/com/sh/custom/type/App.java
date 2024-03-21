package com.sh.custom.type;

import java.util.Arrays;

/**
 * <pre>
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //클래스 사용전
        String id= "user01";
        String pwd = "pass01";
        String name= "홍길동";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구","볼링","테니스"};

        //메소드 호출시 불편
        printMemberInfo(id,pwd, name,age,gender,hobbies);
        //  generateMember();

        //사용자 정의 자료형 Member 사용
        Member member = new Member();

        member.id = "user02:";
        member.name = "홍길동";
        member.pwd = "pass";
        member.age = 20;
        member.gender = '남';
        member.hobbies = new String[]{"등산", "야구", "볼링"};

        new App().printMemberInfo(member);
        Member member2 = new App().generateMember();
        new App().printMemberInfo(member2);

    }

    private static void printMemberInfo(String id, String pwd, String name, int age, char gender, String[] hobbies){

    }
    public void printMemberInfo(Member member){ //Call-by-reference
        System.out.println(member.name);
        System.out.println(member.id);
        System.out.println(member.pwd);
        System.out.println(member.gender);
        System.out.println(member.age);
        System.out.println(Arrays.toString(member.hobbies));
    }

    public Member generateMember(){
        Member member = new Member();
        member.id = "user03:";
        member.name = "박다래";
        member.pwd = "bigsmall";
        member.age = 90;
        member.gender = '여';
        member.hobbies = new String[]{"먹방", "수영", "스키"};

        return member;
    }

}
