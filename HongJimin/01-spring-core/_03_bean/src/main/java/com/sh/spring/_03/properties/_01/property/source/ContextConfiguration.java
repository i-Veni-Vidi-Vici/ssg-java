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

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopeSingleton")
@PropertySource("/product-info.properties") // src/main/resource/product-info.properties안에 적힌 내용을 읽어오기 위함
public class ContextConfiguration {
    @Value("${bread.breadName}")
    private String breadName;
    @Value("${bread.breadPrice}")
    private int breadPrice;
    @Value("${bread.breadBakedAt}")
    private String breadBakedAt;

    // String -> LocalDateTime객체(springboot 사용 안할 때)
    @Value("#{T(java.time.LocalDateTime).parse('${bread.breadBakedAt}')}")
    private LocalDateTime _breadBakedAt;

    /**
     * 메소드 명이 beanname으로 사용될 수 있다.
     *
     * @return
     */
    @Bean
    public Product carpBread() { // 부모타입으로 잡으면, 메소드 이름을 빈 이름으로 사용하기도 함
        System.out.println(_breadBakedAt); // 2024-06-12T11:30:31
        return new Bread(breadName, breadPrice, LocalDateTime.parse(breadBakedAt));
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
}
