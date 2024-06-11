package com.sh.spring._01.dl;

import com.sh.spring.common.account.Account;
import com.sh.spring.common.account.DefaultAccount;
import com.sh.spring.common.account.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationDI") // Bean 관련 설정 할꺼다
public class ContextConfiguration {

    @Bean
    public Account account(){
        return new DefaultAccount(20,"110-123-45678"); // AccountBean 생성
    }

    @Bean
    public MemberDto memberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(1L);
        memberDto.setName("홍길동");
        memberDto.setPhone("010-1234-5678");
        memberDto.setEmail("honggd@gmail.com");

        //Account DI
        memberDto.setAccount(account()); // 만든 빈을 가져와야되니까 반드시 @Bean메소드의 호출결과를 전달해야 한다. new 해서 객체 직접 만들지 마셈
        return memberDto;
    }
}
