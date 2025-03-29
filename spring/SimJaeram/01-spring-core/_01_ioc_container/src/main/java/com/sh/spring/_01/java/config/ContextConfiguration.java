package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 설정 관련 클래스다라고 어노테이션을 활용하여 명시
@Configuration("configurationJava")
public class ContextConfiguration {

    // 이 객체가 빈으로 관리된다.
    @Bean(name="member")
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
