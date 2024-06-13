package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 이미 컴포넌트 추가임 서비스 어노테이션 안에
@Service("pokemonServiceByList")
public class PokemonService {


    private List<Pokemon> pokemons;

    // 이거 채우는 생성자
    @Autowired
    public PokemonService(List<Pokemon> pokemons) {
        this.pokemons = pokemons; // 전달받은 포켓몬
    }

    public void attack() {
        this.pokemons.forEach(Pokemon::attack);
    }
}
