package com.sh.spring._02.autowired._03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        BookService bookService = context.getBean("bookServiceBySetter", BookService.class);

        // 전체 조회
        bookService.findAll().forEach(System.out::println);

        // 한건 조회
        System.out.println(bookService.findById(1L));
    }
}
