package com.sh.spring._03.properties._01.property.source;

import com.sh.spring.common.product.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration("contextConfigurationScopePrototype")
@PropertySource("/product-info.properties") // src/main/resource하위 경로
public class ContextConfiguration {
    @Value("${bread.breadName}")
    private String breadName;
    @Value("${bread.breadPrice}")
    private int breadPrice;
    @Value("${bread.breadBakedAt}")
    private String breadBakedAt;

    // String -> LocalDateTime객체 (springboot사용안할때)
    @Value("#{T(java.time.LocalDateTime).parse('${bread.breadBakedAt}')}")
    private LocalDateTime _breadBakedAt;

    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있다.
     * @return
     */
    @Bean
    public Product carpBread() {
        System.out.println(_breadBakedAt); // 2024-06-12T11:30:31
        // yyyy-MM-ddThh:mm:ss
        return new Bread(breadName, breadPrice, LocalDateTime.parse(breadBakedAt, DateTimeFormatter.ISO_DATE_TIME));
    }
    @Bean
    public Product milk(
            @Value("${beverage.milk.milkName}") String milkName,
            @Value("${beverage.milk.milkPrice}") int milkPrice,
            @Value("${beverage.milk.milkCapacity}") int milkCapacity) {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }
    @Bean
    public Product water(
            @Value("${beverage.water.waterName}") String waterName,
            @Value("${beverage.water.waterPrice}") int waterPrice,
            @Value("${beverage.water.waterCapacity}") int waterCapacity) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }
    @Bean
    @Scope("prototype")
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }

    /**
     * 빈생성시에 @PostConstruct 호출, 빈제거시에 @PreDestroy 호출
     * @return
     */
    @Bean
    public Owner2 owner() {
        return new Owner2();
    }
}
