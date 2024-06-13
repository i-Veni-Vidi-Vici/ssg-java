package com.sh.spring._02.autowired._03.setter;

import com.sh.spring._02.autowired._01.field.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // 위랑 둘다 작동하는 코드!!
        BookService bookService = context.getBean("bookServiceBySetter", BookService.class);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));
    }
}
