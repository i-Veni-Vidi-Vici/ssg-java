package com.sh.spring._02.autowired._02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com.sh.spring");
        System.out.println("ApplicationContext 초기화 완료...");
    }
}
