package com.sh.spring._03.annotation._03.resource;

import com.sh.spring.common.pockemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByResource")
public class PokemonService {
    /**
     * .@Resource 는 스프링이 아닌 java 스펙이다.
     * - name 속성으로 특정 빈을 한정할 수 있다.
     * - 생성자 레벨에서 작성 불가
     */
    @Resource
    private List<Pokemon> pokemons;

    public void attack() {
        this.pokemons.forEach(Pokemon::attack);
    }
}
