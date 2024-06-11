package com.sh.spring._03.annoation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceByMap")
public class PockemonService2 {
    private Map<String, Pokemon> pokemonMap;

    /**
     * key = beanname:String
     * value = bean:Pokemon
     * @param pokemonMap
     */

    @Autowired
    public PockemonService2(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void attack() {
        this.pokemonMap.forEach((k,v) -> {
            System.out.println(k + " = " + v);
            v.attack();
        });
    }
}
