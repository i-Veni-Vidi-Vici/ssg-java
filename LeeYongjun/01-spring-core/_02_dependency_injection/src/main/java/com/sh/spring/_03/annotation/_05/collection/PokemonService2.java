package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceByMap")
public class PokemonService2 {
    private Map<String,Pokemon> pokemonMap;
//    @Autowired
    public PokemonService2(Map<String,Pokemon> pokemonMap){
        this.pokemonMap = pokemonMap;
    }

    public void attack(){
        this.pokemonMap.forEach((k,v) -> {
            System.out.println(k + " = " + v);
            v.attack();
        });
    }
}
