package com.sh.spring._03.annoation._03.resource;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByResource2")
public class PokemonService2 {
    /**
     * @Resource는 스프링이 아닌 자바 스펙이다.
     * - name 속성으로 특정 빈을 한정할 수 있다.
     */
    @Resource
    private List<Pokemon> pokemons;

    public void attack() {
//        this.pokemons.forEach((pokemon) -> {pokemon.attack();});
        this.pokemons.forEach(Pokemon::attack); // 위와 똑같은 코드
    }
}
