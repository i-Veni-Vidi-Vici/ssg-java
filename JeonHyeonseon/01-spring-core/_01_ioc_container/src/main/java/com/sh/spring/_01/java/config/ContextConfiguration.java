package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava") // 이름부여가능
public class ContextConfiguration {

    /**
     * name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입)명이 name값이 된다.
     * name값이 해당 bean객체의 식별자 역할을 하게된다.
     * @return
     */
    @Bean(name="member") // 실제 MemberDto객체가 Bean에서 관리된다. Bean의 아이디와 name을 같다고 생각하기
//    @Bean("member") // name속성이 value속성이다. 위와 같다.
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
