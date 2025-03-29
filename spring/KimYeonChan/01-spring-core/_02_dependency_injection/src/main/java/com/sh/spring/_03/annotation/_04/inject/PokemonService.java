package com.sh.spring._03.annotation._04.inject;

import com.sh.spring.common.pockemon.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByInject")
public class PokemonService {
    // @Named(name)을 통해 동일 타입 빈을 한정할 수 있다.
    // 생성자/메소드 레벨에 @Inject 작성시 @Named 파라미터레벨에 작성해야 한다.

//    @Inject
//    @Named("squirtle")
    private Pokemon pokemon;

//    @Inject
//    public PokemonService(@Named("squirtle") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    @Inject
    public void setPokemon(@Named("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
