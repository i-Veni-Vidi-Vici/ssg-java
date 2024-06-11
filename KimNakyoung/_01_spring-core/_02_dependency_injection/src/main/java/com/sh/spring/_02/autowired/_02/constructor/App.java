package com.sh.spring._02.autowired._02.constructor;

import com.sh.spring._02.autowired._01.fileld.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
//        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        System.out.println("ApplicationContext 초기화 완료..");

        // 등록된 빈을 확인
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);



        // 이 주소 하위의 모든 클래스가 빈으로 등록됨
        BookService bookService = context.getBean("bookServiceByConstructor", BookService.class); // 가져올 빈의 이름은 bookServiceByConstructor이거
        bookService.findAll().forEach(System.out::println);
        System.out.println(bookService.findById(1L)); // 한건 조회
    }
}
