package com.sh.spring._03.annotation._02.qualifier;

import com.sh.spring._03.annotation._01.primary.PokemonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        com.sh.spring._03.annotation._01.primary.PokemonService pokemonService = context.getBean("pokemonServiceByQualifier", PokemonService.class);
        pokemonService.attack();
    }
}
