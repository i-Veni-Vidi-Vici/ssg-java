package com.sh.spring._02.autowired._01.fileld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 이 주소 하위의 모든 클래스가 빈으로 등록됨
        BookService bookService = context.getBean("bookServiceByField", BookService.class);
        bookService.findAll().forEach(System.out::println);
        System.out.println(bookService.findById(1L)); // 한건 조회
    }
}
