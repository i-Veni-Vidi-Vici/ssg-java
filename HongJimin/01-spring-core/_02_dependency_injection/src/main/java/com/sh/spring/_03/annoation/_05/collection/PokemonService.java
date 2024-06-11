package com.sh.spring._03.annoation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByList")
public class PockemonService {
    private List<Pokemon> pokemons;

    @Autowired
    public PockemonService(List<Pokemon> pokemons) {

        this.pokemons = pokemons;
    }

    public void attack() {
        this.pokemons.forEach(Pokemon::attack);
    }
}
