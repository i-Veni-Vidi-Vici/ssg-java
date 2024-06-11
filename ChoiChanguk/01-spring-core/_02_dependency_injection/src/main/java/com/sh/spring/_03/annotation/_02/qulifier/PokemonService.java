package com.sh.spring._03.annotation._02.qulifier;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PokemonServiceByQualifier")
public class PokemonService {
    /**
     * @Primary와 @Qualifier를 동시 사용하는 경우 @Qualifierrk 우선순위가 더 높다
     */
    @Autowired
    @Qualifier("pikachu")
    private Pokemon pokemon;// 생성자레벨에는 작성불가,@Autowired로 ID가능한 bean중에 이름을 bean을 선정

    public void attack() {
        this.pokemon.attack();
    }
}
