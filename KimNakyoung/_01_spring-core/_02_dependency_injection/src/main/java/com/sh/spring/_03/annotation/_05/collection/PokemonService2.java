package com.sh.spring._03.annotation._05.collection;

import com.sh.spring.common.pokemon.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

// 이미 컴포넌트 추가임 서비스 어노테이션 안에
@Service("pokemonServiceByMap")
public class PokemonService2 {

    /**
     *
     * key = beanname:String
     * value = bean:Pokemon
     *
     * @Param pokemonMap
     *
     */


    private Map<String, Pokemon> pokemonMap;

    // 이거 채우는 생성자
    @Autowired
    public PokemonService2(Map<String,Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap; // 전달받은 포켓몬
    }

    public void attack() {
        this.pokemonMap.forEach((k, v) -> {
                System.out.println(k + " = " + v);
        v.attack();
    });

}
}