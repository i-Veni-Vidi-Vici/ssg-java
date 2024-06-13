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

@Configuration("contextConfigurationScopePrototype")
@PropertySource("/product-info.properties")  //src/main/resource 하위 경로
public class ContextConfiguration {
    @Value("${bread.breadName}")
    private String breadName;
    @Value("${bread.breadPrice}")
    private int breadPrice;
    @Value("${bread.breadBakedAt}")
    private String breadBakedAt;
    //String -> LocalDateTime 객체
//    @Value("#{T(java.time.LocalDateTime).parse('${bread.breadBakedAt}')}")
//    private LocalDateTime _breadBakedAt;

    @Bean
    public Product carpBread(){
        return new Bread(breadName, breadPrice, LocalDateTime.parse(breadBakedAt));
    }

    @Bean
    public Product milk(
            @Value("${beverage.milk.milkName}") String milkName,
            @Value("${beverage.milk.milkPrice}") int milkPrice,
            @Value("${beverage.milk.milkCapacity}") int milkCapacity){
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(
            @Value("${beverage.water.waterName}")String waterName,
            @Value("${beverage.water.waterPrice}") int waterPrice,
            @Value("${beverage.water.waterCapacity}") int waterCapacity){
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart shoppingCart(){
        return new ShoppingCart();
    }
}
