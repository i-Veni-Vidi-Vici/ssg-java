package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Spring에서 설정관련 클래스라는 것을 Configuration 어노테이션으로 등록
@Configuration("configurationJava")
public class ContextConfiguration {

    /**
     * name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입)명이 name값이 된다.
     * name 값이 해당 빈 객체의 식별자 역할을 한다.
     * @return
     */
    @Bean ("member") // 이 어노테이션으로 이 객체하나가 Bean으로 관리된다
    // 이 안에있는 member가 곧 value이기도 함 member 앞에 name =을 붙이는것은 자유임.
    public MemberDto meberDto(){
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
