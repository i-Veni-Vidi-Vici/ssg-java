package com.sh.spring._01.scope._03.lazyinit;

import com.sh.spring.common.product.Beverage;
import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationLazyInit") // 💖빈의 이름은 겹치면 안됨!!!
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
    @Scope("singleton") // 기본값
    @Lazy // ApplicationContext 초기화시, 빈을 생성하지 않고 getBean요청시 생성하는 것 -> 생성 시기만 뒤로 늦추는 것
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
