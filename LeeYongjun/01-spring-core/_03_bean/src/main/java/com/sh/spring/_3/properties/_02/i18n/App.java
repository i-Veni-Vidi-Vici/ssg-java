package com.sh.spring._3.properties._02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료...");

        MessageService messageService = context.getBean(MessageService.class);
        // 한국사용자용
        System.out.println(messageService.welcome(Locale.KOREA));
        System.out.println(messageService.greeting(Locale.KOREA,"철수"));
        // 미국사용자용
        System.out.println(messageService.welcome(Locale.US));
        System.out.println(messageService.greeting(Locale.US,"James"));
    }
}
