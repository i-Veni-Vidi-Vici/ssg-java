package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava1")
public class ContextConfiguration {

    /**
     * name을 지정하지 않았다면, 소문자로 시작하는 타입명이 name값이 된다
     * name값이 해당 Bean객체의 식별자 역할을 한다.
     * @return
     */
    //Bean만 사용할수도 있고 이름을 지정할 수도 있다
    // @Bean("member")
    @Bean(name="member")    //name속성 (value속성)
    public MemberDto memberDto(){
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
