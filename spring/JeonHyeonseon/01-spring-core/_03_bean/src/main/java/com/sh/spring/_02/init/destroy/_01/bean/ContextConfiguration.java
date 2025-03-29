package com.sh.spring._02.init.destroy._01.bean;

import com.sh.spring.common.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationPrototype")
public class ContextConfiguration {
    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있다.
     * @return
     */
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
    @Scope("prototype")
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    /**
     * 빈 생성시에 initMethod 호출, 빈 제거시에 closeShop 호출
     * @return
     */
    @Bean(initMethod = "openShop", destroyMethod = "closeShop") // 실제호출하고 싶은 메소드이름을 작성한 것
    public Owner owner() {
        return new Owner();
    }
}
