package com.sh.spring._02.autowired._02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext("com.sh.spring");
        BookService bookService=ac.getBean("bookServiceByConstructor",BookService.class);

        // 동록된 빈을 확인
        Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));
    }
}
