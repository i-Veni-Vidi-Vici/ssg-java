package com.sh.spring._01.scope._02.prototype;

import com.sh.spring.common.product.Beverage;
import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopePrototype")
public class ContextConfiguration {
    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있음
     * @return
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
        return new Beverage("지리산암반수", 3000, 1800);
    }
    @Bean
    @Scope("prototype")
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }
}