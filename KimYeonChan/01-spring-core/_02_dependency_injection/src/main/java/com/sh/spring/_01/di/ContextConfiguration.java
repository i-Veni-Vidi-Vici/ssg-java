package com.sh.spring._01.di;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;
import com.sh.spring.common.account.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationDI")
public class ContextConfiguration {
    @Bean
    public Account account() {
        return new DefaultAccount(20, "3333-13-12345");
    }

    @Bean
    public MemberDto memberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("홍길동");
        memberDto.setPhone("010-1234-1234");
        memberDto.setEmail("honggd@naver.com");
        // Account DI: 반드시 @Bean 메소드의 호출결과를 전달해야 한다.
        memberDto.setAccount(account());
        return memberDto;
    }
}
