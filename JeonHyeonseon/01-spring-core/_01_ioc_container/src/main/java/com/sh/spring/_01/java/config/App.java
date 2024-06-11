package com.sh.spring._01.java.config;

import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성
 *  1. xml기반으로 작성 (spring legacy)
 *  2. java코드 기반으로 작성 : AnnotationConfigApplicationContext객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 */
public class App {
    public static void main(String[] args) {
        // Java기반의 ApplicationContext구현클래스 -> AnnotationConfigApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("🍭ApplicationContext 초기화 완료");

        // bean의 id로 가져오기
        MemberDto memberDto1 = (MemberDto) context.getBean("member"); // Object 반환 (MemberDto) 다운캐스팅
        // 해당 빈을 찾지못하면, 예외발생 NoSuchBeanDefinitionException: No bean named 'member' available
        System.out.println(memberDto1);
        // 클래스(타입)로 가져오기
        MemberDto memberDto2 = context.getBean(MemberDto.class); // 반환타입이 MemberDto로 한정된다.
        System.out.println(memberDto2);
        // id, 클래스로 가져오기
        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 별도의 scope설정이 없다면, 동일한 빈을 제공한다.
        System.out.println(memberDto1 == memberDto2); // 주소값이 같니? true
        System.out.println(memberDto2 == memberDto3); // 주소값이 같니? true
    }
}
