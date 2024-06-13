package com.sh.spring.common.pockemon;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("불꽃세례!!!");
    }
}
