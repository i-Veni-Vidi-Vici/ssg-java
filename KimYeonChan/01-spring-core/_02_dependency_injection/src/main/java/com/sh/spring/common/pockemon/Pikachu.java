package com.sh.spring.common.pockemon;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("10만 볼트!");
    }
}
