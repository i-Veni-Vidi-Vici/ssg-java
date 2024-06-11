package com.sh.spring.common.pokemon;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Squirtle implements Pokemon {
    @Override
    public void attack() {
        System.out.println("⛲⛲꼬부기 물대포!!!~~~ ⛲⛲");
    }
}
