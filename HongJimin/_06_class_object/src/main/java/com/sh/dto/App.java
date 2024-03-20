package com.sh.dto;

/**
 * ### DTO방식 (Data Transfer Object)
 *
 * - 데이터 전송 객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 클래스를 설계할 수 있음
 * - 캡슐화 원칙에 따라 private필드, public 메소드를 작성한다.
 * - 각 필드에 대해 기본적으로 값을 설정하는 setter메소드와 값을 읽기 위한 getter 메소드를 작성해둔다.
 */
public class App {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();

        //객체에 값 작성하기
        memberDto.setId(1);
        memberDto.setName("홍길동");
        memberDto.setAge(20);
        memberDto.setGender('남');
        memberDto.setHeight(177.7);
        memberDto.setWeight(75.5);
        memberDto.setEnabled(true);

        //객체의 값 읽기
        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());
        System.out.println(memberDto.isEnabled());

        //본인의 회원 정보객체 만들기
        MemberDto memberDto2 = new MemberDto();

        //객체에 값 작성하기
        memberDto2.setId(2);
        memberDto2.setName("홍지민");
        memberDto2.setAge(26);
        memberDto2.setGender('여');
        memberDto2.setHeight(115);
        memberDto2.setHeight(13);
        memberDto2.setEnabled(true);

        //객체의 값 읽기
        System.out.println(memberDto2.getId());
        System.out.println(memberDto2.getName());
        System.out.println(memberDto2.getAge());
        System.out.println(memberDto2.getGender());
        System.out.println(memberDto2.getHeight());
        System.out.println(memberDto2.getWeight());
        System.out.println(memberDto2.isEnabled());
    }

}
