package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava")
public class ContextConfiguration {
    /**
     * name을 지정하지 않으면, 소문자로 시작하는 타입명이 name값이 된다.
     * name값이 해당빈객체의 식별자 역할을 한다.
     * @return
     */
//    @Bean("member") // name속성(value속성)
    @Bean
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }



}
