package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava") // 이름 : configurationJava1을 부여할 수 있음!
public class ContextConfiguration {
    /**
     * name을 지정하지 않았다면, 소문자로 시작하는 클래스(타입명)이 name값이 된다.
     * name 값이 해당 빈 객체의 식별자 역할을 한다.
     *
     * @return
     */

    @Bean("member")  // name 속성(= value속성) 내가 지정한 이름으로 bean이 찾을 수 있음
//    @Bean(name = "member")  // 위랑 똑같은 내용
    public MemberDto memberDto() { // MemberDto가 Bean으로 관리됨
        return new MemberDto(1L, "honggd", "1234", "홍길동"); // 반환한애가 어플리케이션으로 관리가 됨
    } // 어플리케이션 컨텍스트 이렇게 만들어주세요! 한 것
}
