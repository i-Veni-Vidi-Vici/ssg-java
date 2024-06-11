package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext(IoC Container) 구성
 * 1. xml 기반 (spring legacy)
 * 2. java 기반: AnnotationConfigurationContext 객체 생성
 *   - @Configuration + @Bean
 *   - @Configuration + @ComponentScan
 */
public class App {
    public static void main(String[] args) {
        // java 기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        // id 로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object 반환
        // 해당빈을 찾지 못하면, 예외발생 NoSuchBeanDefinitionException unchecked
        System.out.println(memberDto1);

        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환
        System.out.println(memberDto2);

        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 별도의 scope 설정이없다면, 동일한 빈을 제공한다.
        System.out.println(memberDto1 == memberDto2); // true
        System.out.println(memberDto2 == memberDto3); // true


    }
}
