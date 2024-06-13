package com.sh.spring._03.annotation._03.resource;

import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceByResource2")
public class PokemonService2 {
    /**
     * @Resource는 스프링이 아닌 자바 스펙(기술)이다.
     * - name 속성으로 특정 빈을 한정할 수 있다.
     * - 생성자 레벨에 사용불가
     */
    @Resource
    private List<Pokemon> pokemon;

    public void attack() {
//        this.pokemon.forEach((pokemon) -> pokemon.attack());
        this.pokemon.forEach(Pokemon::attack);
    }
}
