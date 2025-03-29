package com.sh.spring._03.annotation._04.inject;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByInject")
public class PokemonService {
    /**
     * @Inject는 스프링이 아닌 자바 스펙(기술)이다.
     * - @Named(name)을 통해 동일타입 빈을 한정할 수 있다.
     * - 생성자/메소드 레벨에 @Inject 작성시 @Named는 메소드/파라미터레벨에 작성해야 한다.
     */
//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pikachu) {
//        this.pokemon = pokemon;
//    }

    @Inject
    public PokemonService(@Named("pikachu") Pokemon pikachu) {
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
