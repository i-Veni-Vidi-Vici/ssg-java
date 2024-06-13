package com.sh.spring._02.init.destroy._01.bean;


import com.sh.spring.common.product.*;
import jakarta.inject.Named;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration("contextConfigurationScopePrototype")
public class ContextConfiguration {

    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있다.
     * @return
     */
    @Bean
    public Product carpBread() {
        return new Bread("붕어빵",1000, LocalDateTime.now());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유",1500,500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수",3000,1800);
    }

    @Bean
    @Scope("prototype") // 기본값
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    // 빈 생성시에 실행하고 싶은 메소드, 빈 제거시게 실행하고 싶은 메소드
    public Owner owner() {
        return new Owner();
    }
}
