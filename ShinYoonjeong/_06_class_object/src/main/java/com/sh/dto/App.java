package com.sh.dto;

/**
 * <pre>
 * DTO Data Transfer Object
 * - 데이터 전송객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계 할 수 있다.
 * - 캡슐화원칙에 따라 private필드, public 메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter메소드와 값을 읽기위한 getter메소드를 작성해둔다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();
        // 객체에 값 작성하기
        memberDto.setId(1);
        memberDto.setName("홍길동");
        memberDto.setAge(20);
        memberDto.setGender('남');
        memberDto.setHeight(177.7);
        memberDto.setWeight(75.5);
        memberDto.setEnabled(true);

        // 객체의 값 읽기
        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());
        System.out.println(memberDto.isEnabled());

        // 본인의 회원정보 객체 만들기
        MemberDto memberDto2 = new MemberDto();
        memberDto2.setId(2L);
        memberDto2.setName("신사임당");
        memberDto2.setAge(40);
        memberDto2.setGender('여');
        memberDto2.setHeight(160.5);
        memberDto2.setWeight(55.7);
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