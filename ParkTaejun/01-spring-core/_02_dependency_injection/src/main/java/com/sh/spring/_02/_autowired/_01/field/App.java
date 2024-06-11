package com.sh.spring._02._autowired._01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.print.Book;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring"); // 하위의 모든 클래스가 빈으로 등로된다?
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        BookService bookService = context.getBean("bookServiceByField", BookService.class);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));
    }
}
