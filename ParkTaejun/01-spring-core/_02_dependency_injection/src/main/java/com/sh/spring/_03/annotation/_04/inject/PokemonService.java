package com.sh.spring._03.annotation._04.inject;


import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;


@Service("pokemonServiceByInject")
public class PokemonService {
    /**
     * 인젝트는 스프링이 아닌 자바 스펙
     * 네임드를 통해 빈을 한정할 수 있다.
     * 생성자 메소드레벨에 인제긑 작성시 네임드는 메소드 파라미터베렙ㄹ에 작성할 수 있다.
     */

//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

    @Inject
    public void setPokemon(@Named("pikachu")Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void attack(){
        this.pokemon.attack();
    }

}
