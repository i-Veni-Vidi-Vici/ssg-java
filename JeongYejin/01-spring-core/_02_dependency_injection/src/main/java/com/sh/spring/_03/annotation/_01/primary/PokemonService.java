package com.sh.spring._03.annotation._01.primary;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("pokemonServiceByPrimary")
public class PokemonService {
    private Pokemon pokemon;

//    @Autowired
    public PokemonService(Pokemon pokemon) { // pokemon 빈이 하나만 필요해 세 개나 있네 . . 인터페이스라서 여러개 만들 수 있어서 그래
        // 여러개가 헷갈리면 우선적인(@Primary) 거를 쓰면 돼
        this.pokemon = pokemon;
    }

    public void attack(){
        this.pokemon.attack();
    }
}
