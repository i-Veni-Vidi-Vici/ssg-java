package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceByMap")
public class PokemonService2 {
    private Map<String, Pokemon> pokemonMap;

    /**
     * key = beanname:String
     * value = bean:Pokemon
     *
     * @param pokemonMap
     */
    @Autowired
    public PokemonService2(Map<String, Pokemon> pokemonMap) { // Unsatisfied dependency expressed through constructor parameter 0: No qualifying bean of type 'com.sh.spring.common.pokemon.Pokemon' available: expected single matching bean but found 3: charmander,pikachu,squirtle
        this.pokemonMap = pokemonMap;
    }

    public void attack() {
        this.pokemonMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
            v.attack();
        });
    }
}
