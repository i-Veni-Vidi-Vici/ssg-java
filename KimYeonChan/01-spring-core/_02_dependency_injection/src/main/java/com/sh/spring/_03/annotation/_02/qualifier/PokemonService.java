package com.sh.spring._03.annotation._02.qualifier;

import com.sh.spring.common.pockemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByQualifier")
public class PokemonService {
    /**
     * .@Primary 와 @Qualifier 를 동시에 사용하는 경우 @Qualifier 가 우선순위가 더 높다.
     */
    @Autowired
    @Qualifier("pikachu") // 생성자 레벨에는 작성 불가, @Autowired 로 DI 가능한 빈중에 이름을 빈을 선정
    private Pokemon pokemon;

    public void attack() {
        this.pokemon.attack();
    }
}
