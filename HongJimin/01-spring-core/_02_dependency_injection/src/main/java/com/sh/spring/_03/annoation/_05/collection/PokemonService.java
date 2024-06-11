package com.sh.spring._03.annoation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByList")
public class PokemonService {
    private List<Pokemon> pokemons;

    @Autowired
    public PokemonService(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void attack(){
        this.pokemons.forEach(Pokemon::attack);
    }
}
