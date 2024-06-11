package com.sh.spring._02.annotation.config;

import com.sh.spring.common.member.MemberDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료");

        // 등록된 빈 순회
        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach((beanName) -> System.out.println(beanName)); // 전달받은 메소드를 그대로 출력해주세요
                .forEach(System.out::println); // 위와 같은 의미의 코드

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);

    }
}
