package com.sh.spring._02.autowired._03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        BookService bookService = context.getBean("bookServiceBySetter", BookService.class);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));

    }
}
