package com.sh.spring._02.init.destroy._01.bean;

import com.sh.spring.common.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopePrototype")
public class ContextConfiguration {
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
        return new Beverage("삼다수", 700, 1000);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }

    /**
     * @Bean(initMethod, destroyMethod)
     * 빈 생성시에 initMethod 호출, Bean 제거시에 closeShop을 호출
     * @return
     */

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner(){
        return new Owner();
    }
}
