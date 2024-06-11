package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성
 * 1. xml기반 (spring legacy)
 * 2. java기반 : AnnotationConfigApplicationContext 객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 */
public class App {
    public static void main(String[] args) {
        // Java기반 ApplicationContext 구현 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // 객체 생성
        System.out.println("ApplicationContext 초기화 완료 ...");
//        ContextConfiguration contextConfiguration;

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object 반환
        // getBean은 타입을 명시하지 않았을 때는 Object를 반환해서 형변환을 해주어야 한다.

        // 해당 Bean을 찾지 못하면 예외발생
        // NoSuchBeanDefinitionException: No bean named 'member' available
        // unchecked 예외처리
        System.out.println(memberDto1);

        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환
        // 오류(NoUniqueBeanDefinitionException)나므로 이름으로 찾는 getBean메소드 사용
        System.out.println(memberDto2);

        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // MemberDto 객체는 몇 개가 만들어졌을까요?
        // 세 개가 만들어졌으면 생성자 내 출력문이 여러번 찍혔을 것

        // 별도의 scope설정이 없다면, 동일한 빈을 제공한다.
        System.out.println(memberDto1 == memberDto2); // true
        System.out.println(memberDto2 == memberDto3); // true



    }
}
