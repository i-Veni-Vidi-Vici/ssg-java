package com.sh.spring._02.autowired._01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);
        BookService bookService = context.getBean("bookServiceByField", BookService.class);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));

    }
}