package com.sh.spring._03.properties._02.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration("contextConfigurationI18N")
public class ContextConfiguration {

    @Bean
    public MessageSource mesaageSource() {
        // 사용자 로케일(지역)에 따라 재로딩하는 MessageSource인터페이스의 구현클래스이다.
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        // 다국어 처리가 된 message properties를 지정해야 한다.
        messageSource.setBasename("i18n/message"); // src/main/resources 하위 경로를 읽는 것.

        // 메시지 캐싱시간
        messageSource.setCacheSeconds(10); // reload를 10초동안 방지하는 것

        // 기본인코딩 설정
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public MessageService messageService() {
        // mesaageSource의 정보를 넣고 싶을 때 new를 사용하는 것이 아니라 messageSource의 메소드를 호출한다.
        return new MessageService(mesaageSource());
    }
}
