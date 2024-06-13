package com.sh.spring.common.member;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String name;

    public MemberDto() {
//        System.out.println("MemberDto() 기본생성자 호출!");
    }

    public MemberDto(Long id, String username, String password, String name) {
//        System.out.println("MemberDto(id, username, password, name) 생성자 호출!");
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
