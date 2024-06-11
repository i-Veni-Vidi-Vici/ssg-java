package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration("configurationJava")
public class ContextConfiguration {
    @Bean(name="member")
    public MemberDto memberDto() {
        return new MemberDto(1L, "honggd", "1234", "홍길동");
    }
}
