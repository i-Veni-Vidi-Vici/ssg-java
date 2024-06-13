package com.sh.spring._02.init.destory._02.annotation;

import com.sh.spring.common.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopeSingleton")
public class ContextConfiguration {

    /**
     * 메소드 명이 beanname으로 사용될 수 있다.
     * @return
     */
    @Bean
    public Product carpBread() { // 부모타입으로 잡으면, 메소드 이름을 빈 이름으로 사용하기도 함
        return new Bread("붕어빵", 1000, LocalDateTime.now());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산 암반수", 3000, 1800);
    }

    @Bean
    @Scope("prototype") // 기본값
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    /**
     * 빈 생성 시에 @PostConstructor 호출, 빈 제거시에 @Predestroy을 호출
     * @return
     */
    @Bean
    // 실제 호출하고 싶은 메소드 이름을 문자열로 적기
    public Owner2 owner() {
        return new Owner2();
    }
}
