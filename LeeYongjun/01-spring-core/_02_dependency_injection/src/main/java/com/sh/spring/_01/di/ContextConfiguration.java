package com.sh.spring._01.di;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;
import com.sh.spring.common.account.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationDI")
public class ContextConfiguration {
    @Bean
    public Account account(){
        return new DefaultAccount(20, "110-123-45678");
    }

    @Bean
    public MemberDto memberDto(){
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("홍길동");
        memberDto.setPhone("010-1234-5678");
        memberDto.setEmail("dldydwns2020@naver.com");
        // Account DI - 반드시 @Bean메소드의 호출 결과를 전달해야 한다.
        memberDto.setAccount(account());
        return memberDto;
    }
}
