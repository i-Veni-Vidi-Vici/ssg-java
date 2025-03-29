package com.sh.spring._03.annotation._03.resource;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByResource2")
public class PokemonService2 {
    /**
     * @Resource는 Spring이 아닌 JAVA 스펙이다
     *
     */
    @Resource
    private List<Pokemon> pokemons;

    public void attack(){
        this.pokemons.forEach(Pokemon::attack);
    }
}
