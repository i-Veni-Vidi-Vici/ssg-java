package com.sh.spring._01.java.config;

/*
ApplicationContext (Ioc Contrainer) 구성
1. xml기반 (spring legacy)
2. java기반 : AnnotationConfigApplicationContext객체 생성
        - @Configuration + @Bean
        - @Configuration + @ComponentScan
*/

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        // Java기반 ApplicationContext 구현클래스. ioc Congig객체 만들기
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        // id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // id로 가져오면 타입을 명시하지 않으면 기본 object로 반환이여서 형변환을 해줘야한다
            // 해당bean을 찾지못하면, 예외발생 NoSuchBeanDefinitionException : No bean named 'member' available
        System.out.println(memberDto1);
        // 클래스(타입)으로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // 클래스로 가져오면 MemberDto반환
        System.out.println(memberDto2);
        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 실제로 memberDto객체는 딱 하나만 만들어져서 1,2,3 모두 같은 객체(bean)를 반환하고 있다.

        // 별도의 scope 설정이 없다면, 동일한 빈을 제공한다
        System.out.println(memberDto1 == memberDto2); // true
        System.out.println(memberDto2 == memberDto3); // true
    }
}
