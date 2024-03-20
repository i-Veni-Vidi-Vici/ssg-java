package com.sh.dto;

/**
 * <pre>
 * DTO Data Transfer Object
 * - 데이터 전송객체
 * - 클래스가 행위가 아니라 데이터를 보관하고, 전달하기 위한 목적으로 설계할 수 있다.
 * - 캡슐화원칙에 따라 private 필드, public 메소드를 작성한다.
 * - 각 필드에 대해서 기본적으로 값을 설정하는 setter 메소드와 값을 읽기 위한 getter 메소드를 작성해둔다.
 * </pre>
 */
public class Application {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1);
        memberDto.setName("옥주현");
        memberDto.setAge(44);
        memberDto.setGender('여');
        memberDto.setHeight(173);
        memberDto.setWeight(60);
        memberDto.setEnabled(true);
        // {객체명}.method => {this}.method

        // 객체의 값 읽기
        System.out.println(memberDto.getId());
        System.out.println(memberDto.getName());
        System.out.println(memberDto.getAge());
        System.out.println(memberDto.getGender());
        System.out.println(memberDto.getHeight());
        System.out.println(memberDto.getWeight());
        System.out.println(memberDto.isEnabled());
        
        MemberDto yejinDto = new MemberDto();
        yejinDto.setId(2);
        yejinDto.setName("정예진");
        yejinDto.setAge(25);
        yejinDto.setGender('여');
        yejinDto.setHeight(164);
        yejinDto.setWeight(47);
        yejinDto.setEnabled(true);

        System.out.println(yejinDto.getId());
        System.out.println(yejinDto.getName());
        System.out.println(yejinDto.getAge());
        System.out.println(yejinDto.getGender());
        System.out.println(yejinDto.getHeight());
        System.out.println(yejinDto.getWeight());
        System.out.println(yejinDto.isEnabled());

        // 캡슐화 원칙을 위반하나, 데이터 전달을 위해 관례적으로 사용
    }
}
