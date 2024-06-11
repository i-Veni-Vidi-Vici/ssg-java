package com.sh.spring._03.annotation._04.inject;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jdk.jfr.Name;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByInject")
public class PokemonService {
    /**
     * @Inject는 스프링이 아닌 자바스펙이다
     * - @Named(name)을 통해 동일타입 빈을 한정할 수 있다
     * - 생성자 / 메소드레벨에 @Inject 작성시 @Named 메소드/파라미터레벨에 작성해야 한다.
     */

//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

//    @Inject
//    @Named("pikachu")
//    public void setPokemon(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    @Inject
    public void setPokemon(@Named("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack(){
        pokemon.attack();
    }
}
