package com.sh.dto;

import com.sh.custom.type.Member;

/**
 * DTO(Data Transfer Object)
 * - 데이터 전송 객체
 * - 클래스가 행위가 아니라 데이터를 보관하고 전달하기 위한 목적으로 클래스를 설계할 수 있음.
 * - 캡슐화 원칙에 따라서 private 필드 public 메소드를 작성하게 됨.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter 메소드와 값을 읽기 위한 getter 메소드를 작성해준다.
 */
public class App {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();
        MemberDto member = new MemberDto();
        //객체에 값 작성 - setter
        memberDto.setId(1);
        memberDto.setName("홍길동");
        memberDto.setAge(36);
        memberDto.setGender('남');
        memberDto.setHeight(170);
        memberDto.setWeight(50);
        memberDto.setEnabled(true);

        //객체에 값 읽기 - getter
        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());
        System.out.println(memberDto.isEnabled());

        //본인의 회원정보 만들기 - 객체명 : member
        member.setId(1);
        member.setName("오형동");
        member.setAge(26);
        member.setGender('남');
        member.setHeight(177);
        member.setWeight(70);
        member.setEnabled(true);

        System.out.println(member.getId());
        System.out.println(member.getName());
        System.out.println(member.getAge());
        System.out.println(member.getGender());
        System.out.println(member.getHeight());
        System.out.println(member.getWeight());
        System.out.println(member.isEnabled());
    }
}
