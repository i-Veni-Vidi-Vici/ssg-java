package com.sh.spring.common.pokemon;

import org.springframework.stereotype.Component;

@Component("squirtle")
public class Squirtle implements Pokemon{
    @Override
    public void attack() {
        System.out.println("꼬부기~~ 물대포!!💧💧💧");
    }
}
