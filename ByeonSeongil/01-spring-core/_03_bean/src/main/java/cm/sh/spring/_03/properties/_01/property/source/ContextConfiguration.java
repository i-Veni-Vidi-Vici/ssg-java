package cm.sh.spring._03.properties._01.property.source;

import cm.sh.spring.common.product.Beverage;
import cm.sh.spring.common.product.Bread;
import cm.sh.spring.common.product.Product;
import cm.sh.spring.common.product.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

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
    // String -> LocalDateTime객체 (springboot 사용안할때)
    @Value("#{T(java.time.LocalDateTime).parse('${bread.breadBakedAt}')}")
    private LocalDateTime _breadBakedAt;

    /**
     * @Bean 메소드명이 beanname으로 사용될 수 있다.
     * @return
     */
    @Bean
    public Product carpBread() {
        System.out.println(_breadBakedAt);
        return new Bread(breadName, breadPrice, LocalDateTime.parse(breadBakedAt));
    }

    @Bean
    public Product milk(@Value("${beverage.milk.milkName}") String milkName,
                        @Value("${beverage.milk.milkPrice}") int milkPrice,
                        @Value("${beverage.milk.milkCapacity}")
                            int milkCapacity) {
        return new Beverage(milkName, milkPrice, milkCapacity);
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
}
