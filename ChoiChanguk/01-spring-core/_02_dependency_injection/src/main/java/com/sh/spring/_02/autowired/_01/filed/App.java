package com.sh.spring._02.autowired._01.filed;

import com.sh.spring._01.di.ContextConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext("com.sh.spring");
        //ApplicationContext ac=new AnnotationConfigApplicationContext(ContextConfiguration.class);
        BookService bookService=ac.getBean("bookServiceByFiled",BookService.class);

        bookService.findAll().forEach(System.out::println);

        System.out.println(bookService.findById(1L));
    }
}
