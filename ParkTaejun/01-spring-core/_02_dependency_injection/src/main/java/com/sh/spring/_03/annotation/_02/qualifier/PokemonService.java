package com.sh.spring._03.annotation._02.qualifier;


import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceByQualifier")
public class PokemonService {
     // 인터페이스 타입으로 보통 정의함
    /**
     * @Primary와 @Qualifier를 동시 사용하는경우 @Qualifier가 우선순위 더 높다
     */

    @Autowired
    @Qualifier("pikachu")
    private Pokemon pokemon;
    public void attack(){
        this.pokemon.attack();
    }

}
