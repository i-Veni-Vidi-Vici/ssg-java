package com.sh.spring._03.annotation._01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.sh.spring");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PokemonService pokemonService = context.getBean("pokemonServiceByPrimary", PokemonService.class);
        pokemonService.attack(); // 특정 빈에 @primary 추가해서 Charmander의 attack()이 출력된다
    }
}
