package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성
 * 1. xml 기반 (spring legacy) 유지보수할 때 사용 (지금은 Java로만 할 거라 안 쓸 듯?!)
 * 2. java 기반 : AnnotationConfigApplicationContext 객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 */
public class App {
    public static void main(String[] args) {

        // Java 기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료!!!");

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object 반환
        // 해당 Bean을 찾지 못하면, NoSuchBeanDefinitionException: No bean named 'member' available 예외발생 (unchecked, RuntimeException의 후손)
        System.out.println(memberDto1);
        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환
        System.out.println(memberDto2);
        // id, 클래스 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 실제로 MemberDto 객체는 하나만 만들어짐.
        // 별도의 scope 설정이 없다면, 동일한 Bean 제공
        System.out.println(memberDto1 == memberDto2); // true
        System.out.println(memberDto2 == memberDto3); // true
    }
}
