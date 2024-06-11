package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava")
public class ContextConfiguration {

    /**
     * name 지정하지 않았다면, 소문자로 시작하는 타입명(클래스명)이 name값이 된다.
     * name값이 해당 빈객체의 식별자 역할을 한다.
     * @return
     */

//    @Bean
//    @Bean(name = "member")
    @Bean("member") // name속성(value속성)
    public MemberDto memberDto1(){
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }

//    @Bean("member2")
//    public MemberDto memberDto2(){
//        return new MemberDto(1L, "honggd", "1234", "홍길동");
//    }

}
