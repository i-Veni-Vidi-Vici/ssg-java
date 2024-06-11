package com.sh.spring._02.annotation.config;

import com.sh.spring.common.member.MemberDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        // 등록된 Bean 순회
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);
    }
}
