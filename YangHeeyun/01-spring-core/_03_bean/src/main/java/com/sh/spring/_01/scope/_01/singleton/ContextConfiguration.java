package com.sh.spring._01.scope._01.singleton;

import com.sh.spring.common.product.Beverage;
import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopeSingletone")
public class ContextConfiguration {
    /*
    @Bean 메소드명이 bean name으로 사용도리 수 있다.
     */
    @Bean
    public Product carpBread(){
        return new Bread("붕어빵", 1000, LocalDateTime.now());
    }

    @Bean
    public Product milk(){
        return new Beverage("딸기우유", 1500, 500);
    }
    @Bean
    public Product water(){
        return new Beverage("지리산암반수",3000,1800);
    }
    @Bean
    @Scope("singleton") // Scope는 singleton이 기본값
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }
}
