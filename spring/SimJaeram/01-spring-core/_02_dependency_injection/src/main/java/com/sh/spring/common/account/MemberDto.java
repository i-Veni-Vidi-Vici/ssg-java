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
    private Account account; // Account는 인터페이스, 구현한 클래스의 객체를 가지고 있다.

}
