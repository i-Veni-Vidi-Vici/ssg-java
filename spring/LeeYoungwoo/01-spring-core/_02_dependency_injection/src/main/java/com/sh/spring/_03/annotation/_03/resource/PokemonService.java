package com.sh.spring._03.annotation._03.resource;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByResource")
public class PokemonService {
    /**
    @Resource는 스프링이 아닌 자바 스펙이다.
      - name 속성으로 특정 빈을 한정할 수 있다.
      - 생성자 레벨에 사용불가
     */

    @Resource(name = "squirtle")
    private Pokemon pokemon;

    public void attack() {
        this.pokemon.attack();
    }
}
