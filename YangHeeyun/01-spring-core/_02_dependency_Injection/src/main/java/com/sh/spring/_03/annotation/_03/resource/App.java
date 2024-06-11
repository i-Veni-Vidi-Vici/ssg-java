package com.sh.spring._03.annotation._03.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PokemonService pokemonService = context.getBean("pokemonServiceByResource", PokemonService.class);
        pokemonService.attack();

        PokemonService2 pokemonService2 = context.getBean("pokemonServiceByResource2", PokemonService2.class);
        pokemonService2.attack();
    }
}
