package com.sh.spring._03.annotation._02.qualifier;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByQualifier")
public class PokemonService {
    /**
     * @Primary와 @Qualifier를 동시 사용하는 경우 @Qualifier가 우선순위가 더 높다.
     */
    @Autowired
    @Qualifier("pikachu") // 생성자레벨에는 작성불가, @Autowired로 DI가능한 Bean 중에 이름을 Bean을 선정
    private Pokemon pokemon;

    public void attack(){
        this.pokemon.attack();
    }
}
