package com.sh.spring._03.annotation._03.resource;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByResource2")
public class PokemonService2 {
    /**
     * @Resource는 스프링이 아닌 자바 스펙이다.
     * - name속성으로 특정 빈을 한정할 수 있다.
     */
    @Resource
    private List<Pokemon> pokemons;

    public void attack(){
//        this.pokemons.forEach((pokemon) -> pokemon.attack()); // 아래와 같은 의미
        this.pokemons.forEach(Pokemon::attack);
    }
}
