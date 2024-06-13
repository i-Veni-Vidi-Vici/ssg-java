package com.sh.spring._03.annotation._04.inject;

import com.sh.spring._03.annotation._03.resource.PokemonService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PokemonService pokemonService = context.getBean("pokemonServiceByInject", PokemonService.class);
        pokemonService.attack();
    }
}
