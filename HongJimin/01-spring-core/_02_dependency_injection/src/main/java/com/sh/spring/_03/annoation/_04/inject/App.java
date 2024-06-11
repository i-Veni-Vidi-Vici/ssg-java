package com.sh.spring._03.annoation._03.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PockemonService pockemonService = context.getBean("pokemonServiceByResource", PockemonService.class);

        PockemonService2 pockemonService2 = context.getBean("pokemonServiceByResource2", PockemonService2.class);
        pockemonService2.attack();

    }
}
