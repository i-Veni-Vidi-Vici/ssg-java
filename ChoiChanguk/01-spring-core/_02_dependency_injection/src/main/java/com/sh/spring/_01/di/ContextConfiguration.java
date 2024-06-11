package com.sh.spring._01.di;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;
import com.sh.spring.common.account.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationDI")
public class ContextConfiguration {


    @Bean
    public Account account() {
        return new DefaultAccount(20,"110-123-123456");
    }

    @Bean
    public MemberDto memberDto() {
        MemberDto memberDto=new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("홍길동");
        memberDto.setPhone("010-1234-5678");
        memberDto.setEmail("honggd@gmail.com");
        memberDto.setAccount(account()); // 이거 중요한 new로 하면 그냥 객체 생성 삽입니다
        // Account Di - 반드시 @Bean 메소드의 호출결과를 전달해야 한다.
        return memberDto;
    }

}
