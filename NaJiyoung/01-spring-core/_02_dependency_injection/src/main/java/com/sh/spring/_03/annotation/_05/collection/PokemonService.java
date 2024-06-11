package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByList")
public class PokemonService {
    private List<Pokemon> pokemons;

    @Autowired
    public PokemonService(List<Pokemon> pokemons) { // Unsatisfied dependency expressed through constructor parameter 0: No qualifying bean of type 'com.sh.spring.common.pokemon.Pokemon' available: expected single matching bean but found 3: charmander,pikachu,squirtle
        this.pokemons = pokemons;
    }

    public void attack() {
        this.pokemons.forEach(Pokemon::attack);
    }
}
