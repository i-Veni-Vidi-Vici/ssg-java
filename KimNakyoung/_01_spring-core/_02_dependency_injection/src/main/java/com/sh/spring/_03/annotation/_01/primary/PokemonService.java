package com.sh.spring._03.annotation._01.primary;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 이미 컴포넌트 추가임 서비스 어노테이션 안에
@Service("pokemonServiceByPrimary")
public class PokemonService {
    private Pokemon pokemon;

    // 이거 채우는 생성자
    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon; // 전달받은 포켓몬
    }

    public void attack() {
        this.pokemon.attack();
    }
}
