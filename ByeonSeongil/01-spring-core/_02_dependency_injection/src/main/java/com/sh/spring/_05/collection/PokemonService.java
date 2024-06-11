package com.sh.spring._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByList")
public class PokemonService {
    private List<Pokemon> pokemon;

    @Autowired
    public PokemonService(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.forEach(Pokemon::attack);
    }
}
