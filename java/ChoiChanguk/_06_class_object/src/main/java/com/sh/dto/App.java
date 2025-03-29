package com.sh.dto;

import com.sh.custom.type.Member;

/**
 * <pre>
 * DTO Data Transfer Object
 * - 데이터 전송객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계 할 수 있따.
 * - 캡슐화원칙에 따라 private필드, public 메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter메소드와 값을 읽기위한 getter메소드를 작성해둔다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        MemberDto memberDto=new MemberDto();
        // 객체에 값 작성하기
        memberDto.setId(1);
        memberDto.setName("홍길동");
        memberDto.setAge(20);
        memberDto.setGender('남');
        memberDto.setHeight(177.7);
        memberDto.setWeight(75.5);
        memberDto.setEnabled(true);

        // 객체의 값 일기
        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());

        MemberDto ccu=new MemberDto();

        ccu.setId(1);
        ccu.setName("최창욱");
        ccu.setAge(33);
        ccu.setGender('남');
        ccu.setHeight(175.7);
        ccu.setWeight(70.5);
        ccu.setEnabled(true);

        System.out.println(ccu.getId());
        System.out.println(ccu.getName());
        System.out.println(ccu.getAge());
        System.out.println(ccu.getGender());
        System.out.println(ccu.getHeight());
        System.out.println(ccu.getWeight());
    }
}
