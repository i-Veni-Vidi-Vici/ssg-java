package com.sh.spring._03.annotation._04.inject;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

// 이미 컴포넌트 추가임 서비스 어노테이션 안에
@Service("pokemonServiceByInject")
public class PokemonService {

    /**
     * @Inject는 스프링이 아닌 자바 스펙이다.
     * -@Named(name)을 통해 동일타입 빈을 한정할 수 있다.
     * - 생성자/메소드레벨에 @Inject 작성시 @Named 파라미터레벨에 작성할 수 있다.
     */

//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

    // 파라미터 레벨에 써주기

//    @Inject
//    public PokemonService(@Named("pikachu")Pokemon pokemon) {
//        this.pokemon = pokemon; // 전달받은 포켓몬
//    }

    @Inject
    public void setPokemon(@Named("pikachu") Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public void attack() {
        this.pokemon.attack();
    }
}
