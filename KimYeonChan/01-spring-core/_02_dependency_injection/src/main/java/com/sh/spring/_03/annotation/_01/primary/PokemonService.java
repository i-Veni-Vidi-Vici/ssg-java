package com.sh.spring._03.annotation._01.primary;

import com.sh.spring.common.pockemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("pokemonServiceByPrimary")
public class PokemonService {
    private Pokemon pokemon;

//    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
