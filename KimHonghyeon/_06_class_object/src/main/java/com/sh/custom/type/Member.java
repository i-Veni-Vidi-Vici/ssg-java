package com.sh.custom.type;


import java.util.Arrays;

/**
 * 사용자 정의 자료형
 * - 다른 타입의 값 n개에 해당하는 변수를 선언하고 묶어낼 수 있다.
 */
public class Member {
    String id, pwd, name;
    int age;
    char gender;
    String[] hobbies;

    Member(){

    }

    Member(String id, String pwd, String name, int age, char gender, String[] hobbies){
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;

    }
    public static Member generateMember(){
        Member member = new Member();
        member.id = "leess";
        member.pwd = "pass03";
        member.name="이순신";
        member.gender='남';
        member.hobbies = new String[]{"농구", "당구"};
        return member;
    }

    public void printMember(){
        System.out.printf("id: %s pwd: %s name: %s age: %d gender: %c\n", id, pwd, name, age, gender);
        System.out.printf("hobbies: %s\n", Arrays.toString(hobbies));
    }
}
