package com.sh.spring._01.java.config;


import com.sh.spring.common.member.MemberDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext (IoC Container) 구성
 *  - 1. xml 기반 ( spring legacy)
 *  - 2. java 코드 기반 : AnnotationConfigApplicationContext 객체 생성
 *      - @Configuration + @Bean
 *      - @Configuration + @ComponentScan
 *      -
 */

public class App {
    public static void main(String[] args) {

        // Java기반 ApplicationContext 구현클래스
        ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료... ");

        //id로 가져오기
        // getBean은 타입 설정해주지 않으면 Object라서 형변환 해줘야함 , 우리가 지정한 member라는 이름으로 찾아올 수 있었음
        MemberDto memberDto1 = (MemberDto) context.getBean("member");
        // 해당 빈을 찾지못하면 예외 발생 .NoSuchBeanDefinitionException: No bean named 'member' available 예외처리를 강제하면 checked, 안하면 unchecked
        // 여기서는 예외처리 강제하지 않았으므로 unchecked 이므로 runtimeExceoption의 후손이다.
        System.out.println(memberDto1);

        // 클래스 (타입)으로 가져오기

        MemberDto memberDto2 = context.getBean(MemberDto.class); // 클래스로 명시해주면 반환타입이 MemberDto로 한정된다 MemberDto 반환
        System.out.println(memberDto2);

        // id, 클래스로 가져오기

        MemberDto memberDto3 = context.getBean("member", MemberDto.class);
        System.out.println(memberDto3);

        // 별도의 scope 설정이 없다면, 동일한 빈을 제공한다.
        // heap 영역의 같은 객체니 ? 전부다 true가 나옴
        System.out.println(memberDto1 == memberDto2);
        System.out.println(memberDto2 == memberDto3);


    }

}

