package com.sh.spring._01.di;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefulatAccount;
import com.sh.spring.common.account.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.attribute.AttributeView;

@Configuration("configurationDI")
public class ContextConfiguration {

    @Bean
    public Account account() {
        return new DefulatAccount(20, "110-123-45678");
    }

    @Bean
    public MemberDto memberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("홍길동");
        memberDto.setPhone("010-1234-5678");
        memberDto.setEmial("honggd@gmail.com");

        // Account DI - 반드시 @Bean 메소드의 호출 결과를 전달해야 한다.
        memberDto.setAccount(account()); // 💖 여기가 제일 중요!! 💖
//        memberDto.setAccount(new DefulatAccount()); // 이렇게 하면 안됨
        return memberDto;
    }
}
