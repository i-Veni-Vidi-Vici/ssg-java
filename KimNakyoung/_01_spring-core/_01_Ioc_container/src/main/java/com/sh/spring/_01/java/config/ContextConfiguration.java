package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationJava1")
public class ContextConfiguration {


    /**
     *
     * name지정하지 않았다면, 소문자로 시작하는 타입명(class명) 이 name값이 된다. (자바에서 class는 동시에 자료형이기도 하기때문에)
     * name값이 해당 빈 객체의 식별자 역할을 한다.
     *
     * @return
     */

    @Bean("member") // name속성(value속성)
//    @Bean(name = "member") // name속성(value속성)
    public MemberDto memberDto(){
        return new MemberDto(1L,"hongdd","1234","홍길동"); // 이 반환한 애가 applicationConfiguration에서 관리가 됨
    }

}
