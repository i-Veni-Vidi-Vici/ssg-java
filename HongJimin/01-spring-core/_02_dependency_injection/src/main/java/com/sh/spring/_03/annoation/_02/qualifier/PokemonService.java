package com.sh.spring._03.annoation._02.qualifier;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByQualifier")
public class PokemonService {
    /**
     * @Primary 와 @Qulifier를 동시 사용하는 경우 @Qulifier가 우선순위가 더 높다.
     */
    @Autowired
    @Qualifier("pikachu") // 생성자 레벨에는 작성 불가, @Autowired로 DI 가능한 반중에 이름을 빈을 선정
    private Pokemon pokemon;

    public void attack() {
        this.pokemon.attack();
    }
}
