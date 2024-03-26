package com.sh.dto;

public class App {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(0);
        memberDto.setName("김홍현");
        memberDto.setAge(28);
        memberDto.setGender('남');
        memberDto.setHeight(175);
        memberDto.setWeight(65);
        memberDto.setEnabled(true);

    }
}
