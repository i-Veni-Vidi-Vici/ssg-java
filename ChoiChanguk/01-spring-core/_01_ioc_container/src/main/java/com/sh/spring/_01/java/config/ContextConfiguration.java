package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava")
public class ContextConfiguration {

    /**
     * name지정하지 않앗다면, 소문자로 시작하는 타입명(클래스명)이 name값이 된다
     * name값이 해당빈객체의 식별자 역할을 한다.
     * @return
     */
//    @Bean("member") 이렇게 써도 된다
    @Bean(name="member") // 이름지정 가능하다
    public MemberDto memberDto(){
        return new MemberDto(1L,"honggd","1234","홍길동");
    }
}
