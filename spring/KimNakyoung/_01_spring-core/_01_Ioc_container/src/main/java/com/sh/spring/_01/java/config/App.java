package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * ApplicationContext (Ioc Container) 구성
 * 1. xml기반 (spring lagacy)
 * 2. java기반 : AnnotationConfigApplicationContext 객체 생성
 *              - @Configuration + @Bean
 *              - @Configuration + @ComponentScan
 *
 */


public class App {
    public static void main(String[] args) {

        //Java기반에 ApplicationContext구현클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // IOC객체만듦
        System.out.println("ApplicationContext 초기화 완료 ");

        //id로 가져오기
        // 지금은 name이라고 생각하기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // object 반환해서 형변환 해줘야함 ! // Object반환
        System.out.println(memberDto1);
        // 클레스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // MemberDto 반환 (반환타입이 MemberDto로 한정됨)
        System.out.println(memberDto2);
        // id,클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 지금 객체 3개 만든게 아니라 멤버객체 1개만 만들어져있는거임
        // 별도의 scope설정이 없다면, 동일한 빈을 제공한다.
        System.out.println(memberDto1 == memberDto2); // 주솟값이 같니? == 힙 영역에 같은 객체니?
        System.out.println(memberDto2 == memberDto3); // 주솟값이 같니?





    }
}
