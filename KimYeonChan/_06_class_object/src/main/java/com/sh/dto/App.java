package com.sh.dto;

/**
 * DTO Data Transfer Object
 * - 데이터 전송 객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계 할 수 있다.
 * - 캡슐화 원칙에 따라 private 필드, public 메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter 메소드와 값을 읽기 위한 getter 메소드를 작성해 둔다.
 */
public class App {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1);
        memberDto.setName("김연찬");
        memberDto.setAge(27);
        memberDto.setGender('남');
        memberDto.setHeight(178);
        memberDto.setWeight(83);
        memberDto.setEnabled(true);

        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());
        System.out.println(memberDto.isEnabled());
    }
}
