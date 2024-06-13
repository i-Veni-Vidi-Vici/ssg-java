package com.sh.spring.common.member;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String userName;
    private String password;
    private String name;

    public MemberDto() {
        System.out.println("MemberDto() 생성자 호출!");
    }

    public MemberDto(Long id, String userName, String password, String name) {
        System.out.println("MemberDto(id, userName, password, name) 생성자 호출!");
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
    }
}
