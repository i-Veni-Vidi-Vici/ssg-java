package cm.sh.spring._02.init.destroy._02.annotation;

import cm.sh.spring.common.product.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration("contextConfigurationScopeAnnotation")
public class ContextConfiguration {
    /**
     * 빈생성시에 @PostConstruct 호출, 빈제거시에 @PreDestory 호출
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
        /**
         * 빈생성시 @PostConstruct 호출, 빈제거시에 @PreDestroy 호출
         */
    }
    @Bean
    public Owner2 owner() {
        return new Owner2();
    }
}
