package com.sh.spring._03.annotation._03.resource;


import com.sh.spring.common.pokemon.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("pokemonServiceByResource")
public class PokemonService {


  @Resource(name = "pikachu")
    private Pokemon pokemon;

    public void attack(){
        this.pokemon.attack();
    }

}
