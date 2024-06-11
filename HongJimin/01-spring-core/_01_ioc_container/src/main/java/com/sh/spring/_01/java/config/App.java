package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

/**
 * ## ApplicationContext (IoC Container)구성
 * - 가장 먼저 해야 할 일은 ApplicationContext(=인터페이스)를 만드는 것!
 * 1. xml 기반(spring legacy) → 얘는 다루지 않을 예정
 * 2. java기반 : AnnotationConfigApplicationContext 객체 생성 → 이렇게 다룰 예정!!
 *     - @Configuration + @Bean
 *     - @Configuration + @ConponentScan
 */
public class App {
    public static void main(String[] args) {
        //Java 기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // ContextConfiguration 밑에 있는 bean이 호출 & 선언됨
        System.out.println("ApplicationContext 초기화 완료🌟");

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // getBean은 타입 지정 안하면 Object 반환함
        System.out.println(memberDto1);
        //해당 빈을 찾지 못하면, 예외 발생 .NoSuchBeanDefinitionException: No bean named 'member' available

        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환
        System.out.println(memberDto2);

        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 별도의 scope설정이 없다면, 동일한 빈을 제공한다.
        System.out.println(memberDto1 == memberDto2); // true
        System.out.println(memberDto2 == memberDto3); // true

    }
}
