package com.sh.spring._03.annoation._01.primary;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByPrimary")
public class PockemonService {
    private Pokemon pokemon;

    @Autowired
    public PockemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
