package com.sh.spring._03.annotation._01.primary;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("pokemonServiceByPrimary")
public class PokemonService {
    private Pokemon pokemon;

//    @Autowired
    public PokemonService(Pokemon pokemon) { // Unsatisfied dependency expressed through constructor parameter 0: No qualifying bean of type 'com.sh.spring.common.pokemon.Pokemon' available: expected single matching bean but found 3: charmander,pikachu,squirtle
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
