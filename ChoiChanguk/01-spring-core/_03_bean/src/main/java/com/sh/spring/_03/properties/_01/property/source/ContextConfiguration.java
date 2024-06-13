package com.sh.spring._03.properties._01.property.source;


import com.sh.spring.common.product.Beverage;
import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Configuration("contextConfigurationScopePrototype")
@PropertySource("/product-info.properties") // src/main/resource하위 경로
public class ContextConfiguration {

    @Value("${bread.breadName}")
    private String breadName;

    @Value("${bread.breadPrice}")
    private int breadPrice;

    @Value("${bread.breadBakedAt}")
    private String breadBakedAt;

    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있다.
     * @return
     */

    @Bean
    public Product carpBread() {
        return new Bread(breadName,breadPrice, LocalDateTime.parse(breadBakedAt));
    }



    @Bean
    public Product milk(@Value("${beverage.milk.milkName}") String milkName
            ,@Value("${beverage.milk.milkPrice}") int milkPrice
            ,@Value("${beverage.milk.milkCapacity}") int milkCapacity) {
        return new Beverage(milkName,milkPrice,milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.waterName}") String waterName
            ,@Value("${beverage.water.waterPrice}") int waterPrice
            ,@Value("${beverage.water.waterCapacity}") int waterCapacity) {
        return new Beverage(waterName,waterPrice,waterCapacity);
    }

    @Bean
    @Scope("prototype") // 기본값
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
