package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성
 * 1. xml 기반 (spring legacy)
 * 2. java 기반: AnnotationConfigApplicationContext 객체 생성
 *  - @Configuration + @Bean
 *  - @Configuration + @ComponentScan
 */
public class App {
    public static void main(String[] args) {
        // Java 기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object가 반환되어 다운 캐스팅 필요
        System.out.println(memberDto1);
        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환되어 다운 캐스팅할 필요 없음
        System.out.println(memberDto2);
        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

    }
}
