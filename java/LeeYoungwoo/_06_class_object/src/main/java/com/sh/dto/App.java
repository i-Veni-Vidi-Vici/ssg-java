package com.sh.dto;
/**
 * <pre>
 * DTO Data Transfer Object
 * - 데이터 전송객체
 * - 클래스가 가진 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계할 수 있다.
 * - 캡슐화 원칙에 따라 private필드, public 메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter 메소드와 값을 읽기 위한 getter 메소드를 작성해둔다.
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        MemberDto memberDto1 = new MemberDto();
        // 객체에 값 작성하기
        memberDto1.setId(1);
        memberDto1.setName("홍길동");
        memberDto1.setAge(20);
        memberDto1.setGender('남');
        memberDto1.setHeight(177.7);
        memberDto1.setWeight(75.5);
        memberDto1.setEnabled(true);

        // 객체의 값 읽기
        System.out.println(memberDto1.getId());
        System.out.println(memberDto1.getName());
        System.out.println(memberDto1.getAge());
        System.out.println(memberDto1.getGender());
        System.out.println(memberDto1.getHeight());
        System.out.println(memberDto1.getWeight());
        System.out.println(memberDto1.isEnabled());
        System.out.println();

        // 본인의 회원정보 객체 만들기
        MemberDto memberDto2 = new MemberDto();

        memberDto2.setId(2);
        memberDto2.setName("이영우");
        memberDto2.setAge(27);
        memberDto2.setGender('남');
        memberDto2.setHeight(170);
        memberDto2.setWeight(62.5);
        memberDto2.setEnabled(true);

        System.out.println(memberDto2.getId());
        System.out.println(memberDto2.getName());
        System.out.println(memberDto2.getAge());
        System.out.println(memberDto2.getGender());
        System.out.println(memberDto2.getHeight());
        System.out.println(memberDto2.getWeight());
        System.out.println(memberDto2.isEnabled());
    }
}
