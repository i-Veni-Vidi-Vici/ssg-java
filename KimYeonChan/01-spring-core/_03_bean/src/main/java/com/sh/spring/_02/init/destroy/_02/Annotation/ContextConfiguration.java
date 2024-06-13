package com.sh.spring._02.init.destroy._02.Annotation;

import com.sh.spring.common.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationAnnotation")
public class ContextConfiguration {
    @Bean
    public Product carpsBread(){
        return new Bread("붕어빵", 1000, LocalDateTime.now());
    }
    @Bean
    public Product milk() {
        return new Beverage("딸기 우유", 1500, 500);
    }
    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 1800);
    }
    @Bean
    @Scope("singleton")
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }

    @Bean
    public Owner2 owner(){
        return new Owner2();
    }
}
