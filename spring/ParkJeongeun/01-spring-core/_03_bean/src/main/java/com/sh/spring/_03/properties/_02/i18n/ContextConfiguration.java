package com.sh.spring._03.properties._02.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration("contextConfigurationI18N")
public class ContextConfiguration {
    @Bean
    public MessageSource messageSource(){
        // 사용자 지역에 따라 메세지를 재로딩하는 MessageSource 인터페이스의 구현클래스
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // 다국어 처리된 message properties // basename 설정
        messageSource.setBasename("i18n/message"); // src/main/resources 하위경로
        // 메세지 캐싱시간
        messageSource.setCacheSeconds(10);
        // 기본 인코딩 설정
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public MessageService messageService(){
        return new MessageService(messageSource()); // 괄호 안에 new 작성X
    }
}