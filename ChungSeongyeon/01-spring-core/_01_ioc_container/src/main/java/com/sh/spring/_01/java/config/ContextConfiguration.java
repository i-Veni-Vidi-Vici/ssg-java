package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava")
public class ContextConfiguration {

    /**
     * Bean의 name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입)명이 name값이 된다.
     * name 값은 해당 Bean 객체의 식별자 역할.
     * @return
     */
    @Bean("member") // name속성이 value 속성이기도 하다. @Bean(name = "member")과 똑같다.
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
