package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava")
public class ContextConfiguration {

    /**
     * name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입)명이 name값이 된다.
     *  - *자바의 클래스는 하나의 자료형이므로 타입이라고도 함*
     * name값이 해당 Bean객체의 식별자 역할을 한다.
     * @return
     */
    @Bean("member") // name속성(value속성)
//    @Bean(name = "member")
//    @Bean
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
