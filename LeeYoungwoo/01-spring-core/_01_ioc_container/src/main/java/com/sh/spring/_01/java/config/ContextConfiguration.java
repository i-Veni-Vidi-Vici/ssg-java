package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 어노테이션을 붙히면 spring이 된다
@Configuration("configurationJava1")
public class ContextConfiguration {

    // 어노테이션을 붙히면 Bean으로 관리된다.
    // @Bean에 name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입)명(memberDto)이 name값이 된다.
    // name앖이 해당 Bean객체의 식별자 역할을 한다.
//    @Bean
    @Bean("member") // name속성(value속성)
//    @Bean(name = "member")
    public MemberDto memberDto(){
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
