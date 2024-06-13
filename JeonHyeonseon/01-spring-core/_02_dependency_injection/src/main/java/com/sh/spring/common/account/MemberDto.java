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
    // Account는 객체지향의 특징 중에 다형성(부모타입의 변수에 자식객체를 넣어서 관리, 상속)에 속함
    private Account account; // 인터페이스 Account(계좌) 구현한 객체
}
