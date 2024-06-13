package com.sh.spring.common.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Account account; // 인터페이스 Account 구현한 객체
}
