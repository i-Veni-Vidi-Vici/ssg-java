package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IOC Container) 구성
 * 1. xml 기반 (spring legacy)
 * 2. java 기반 : AnnotationConfigApplicationContext 객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 */

public class App {
    public static void main(String[] args) {

        //Java기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto)context.getBean("member");
        //해당빈을 찾지 못하면, 예외발생 NoSuchBeanDefinitionException: No bean named 'member' available

        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 =(MemberDto)context.getBean(MemberDto.class);

        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);

        //별도의 scope설정이 없다면, 동일한 Bean을 제공한다
    }
}
