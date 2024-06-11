package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성, Bean이 담긴 객체이다
 * 1. xml기반 (spring legacy 예전에는 많이 썻다) 이거 안할 거임
 * 2. java 코드기반 : AnnotationConfigApplicationContext 객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 *      -
 */
public class App {
    public static void main(String[] args) {

        // java기반 ApplicationContext구현 클래스
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // id로 가져오기
        // 해당 빈의 이름이 있는데 틀리면, No bean named 에러가 뜬다, 예외가 발생했으니깐 unchecked다
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object 리턴
        System.out.println("memberDto1 = " + memberDto1);

        // 클래스(타입) 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // 해당 클래스로 리턴
        System.out.println("memberDto2 = " + memberDto2);

        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class); // 해당 클래스로 리턴
        System.out.println("memberDto3 = " + memberDto3);

        // 별도의 scope설정이 없다면, 동일한 빈을 제공한다 (싱글톤)
        System.out.println(memberDto1.hashCode());
        System.out.println(memberDto2.hashCode());
        System.out.println(memberDto3.hashCode());
    }
}
