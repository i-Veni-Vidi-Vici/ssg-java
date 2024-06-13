package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceByMap")
public class PokemonService2 {
    private Map<String, Pokemon> pokemonsMap;

    @Autowired
    public PokemonService2(Map<String, Pokemon> pokemonMap) {
        this.pokemonsMap = pokemonMap;
    }

    // Map을 순회하는 방법은 다르다.
    public void attack() {
        this.pokemonsMap.forEach();
    }
}
