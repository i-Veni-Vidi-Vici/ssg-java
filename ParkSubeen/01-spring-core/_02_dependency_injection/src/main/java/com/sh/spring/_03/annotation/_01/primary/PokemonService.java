package com.sh.spring._03.annotation._01.primary;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("pokemonServiceByPrimary") // 실행 시 주석 제거
public class PokemonService {
    private Pokemon pokemon;

//    @Autowired // 실행 시 주석 제거
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack(){
        this.pokemon.attack();
    }
}
