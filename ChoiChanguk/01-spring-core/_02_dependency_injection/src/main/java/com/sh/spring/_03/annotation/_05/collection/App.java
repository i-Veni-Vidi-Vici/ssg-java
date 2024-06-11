package com.sh.spring._03.annotation._05.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext("com.sh.spring");

        Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
        PokemonService bean = ac.getBean("pokemonServiceByList", PokemonService.class);

        bean.attack();
    }
}
