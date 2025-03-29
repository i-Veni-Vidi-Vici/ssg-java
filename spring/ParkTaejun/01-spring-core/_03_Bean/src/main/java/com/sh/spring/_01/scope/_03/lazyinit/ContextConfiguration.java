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

@Configuration("contextConfigurationLazyInit")
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, LocalDateTime.now());
    }
    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1500, 500);
    }
    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1800);
    }
    @Bean
    @Scope("singleton")
    @Lazy // ApplicationContext 초기화 시 빈을 생성하지 않고, getBean 요청시 생성..
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
