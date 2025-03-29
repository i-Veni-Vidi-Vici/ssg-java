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
    private String emial;
    private Account account; // 인터페이스(Account )를 구현한 객체를 가지고 있을 것! -> 🌟다형성 적용🌟 => Account 빈을 따로있을 때, 의존이 필요하기 때문에 추가함 = Dependency Injection
    // MemberDto Bean을 만들거고, 거기엔 Accout Bean도 있을 것!
}
