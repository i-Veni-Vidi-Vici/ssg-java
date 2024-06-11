package com.sh.spring._03.annotation._05.collection;


import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("pokemonServiceByMap")
public class PokemonService2 {
    /**
     * key = beanname = String
     * value = bean : Pokemon
     */

    private Map<String, Pokemon> pokemonMap;


 @Autowired
 public PokemonService2(Map<String, Pokemon> pokemonMap){
     this.pokemonMap = pokemonMap;
 }

    public void attack(){
        this.pokemonMap.forEach((k, v) -> { //v는 포케몬 객체
            System.out.println(k + " = " + v);l
            v.attack();
        });

        /**
         * Runnable () -> {}
         * Consumer (a) -> {}
         * Supplier () -> a
         * Function (a) -> b
         * Predicate (a) -> bool
         */


    }

}
