package com.sh.spring._3.properties._02.i18n;

import com.sh.spring.common.product.Beverage;
import com.sh.spring.common.product.Bread;
import com.sh.spring.common.product.Product;
import com.sh.spring.common.product.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.time.LocalDateTime;

@Configuration("contextConfigurationI18N")
public class ContextConfiguration {
    @Bean
    public MessageSource messageSource(){
        // 사용자 오케일에 따라 메세지를 재로딩하는 MessageSource인터페이스의 구현클래스
        ReloadableResourceBundleMessageSource messageSource= new ReloadableResourceBundleMessageSource();
        // 다국어 처리된 message properties
        messageSource.setBasename("i18n/message"); // src/main/resources
        // 메세지 캐싱시간
        messageSource.setCacheSeconds(10);
        // 기본인코딩설정
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public MessageService messageService(){
        return new MessageService(messageSource());
    }
}
