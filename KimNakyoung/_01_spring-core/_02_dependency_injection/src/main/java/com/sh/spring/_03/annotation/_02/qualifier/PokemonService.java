package com.sh.spring._03.annotation._02.qualifier;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 이미 컴포넌트 추가임 서비스 어노테이션 안에
@Service("pokemonServiceByQualifier")
public class PokemonService {

    /**
     * @Primary와 @Qualifier를 동시 사용하는 경우 @Qualifier가 우선순위가 더 높다
     *
     */


    @Autowired
    @Qualifier("pikachu") //@Autowired로 DI가능한 빈 중에 이름을 빈을 선정
    private Pokemon pokemon;

    // 이거 채우는 생성자
//    @Autowired
//    @Qualifier("pickachu") // 이거 생성자는 안됨 생성자레벨에는 작성불가,
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon; // 전달받은 포켓몬
    }

    public void attack() {
        this.pokemon.attack();
    }
}
