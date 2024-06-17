package com.sh.spring._03.annotation._01.primary;


import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("pokemonServiceByPrimary")
public class PokemonService {
    private Pokemon pokemon; // 인터페이스 타입으로 보통 정의함

//    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack(){
        this.pokemon.attack();
    }
}
