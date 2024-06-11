package com.sh.spring._02.annotation.config;

import com.sh.spring.common.member.MemberDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 등록된 빈 순회
        Arrays.stream(ac.getBeanDefinitionNames())
                .forEach((System.out::println));

    }
}
