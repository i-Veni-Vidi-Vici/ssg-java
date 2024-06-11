package com.sh.spring.common.pokemon;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon{

    @Override
    public void attack() {
        System.out.println("피카츄~⚡⚡🌩️🌩️");

    }
}
