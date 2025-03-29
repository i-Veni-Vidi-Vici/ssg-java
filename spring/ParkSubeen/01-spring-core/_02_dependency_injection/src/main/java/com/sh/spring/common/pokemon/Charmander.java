package com.sh.spring.common.pokemon;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Pokemon{
    @Override
    public void attack() {
        System.out.println("파이리 불꽃공격~ 🔥🔥🔥");
    }
}
