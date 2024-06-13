package com.sh.spring._03.properties._02.I18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration("contextConfigurationI18N")
public class ContextConfiguration {
    @Bean
    public MessageSource messageSource() {
        //사용자 로케일에 따라 메세지를 재로딩하는
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        //다국어 처리된 message properties
        messageSource.setBasename("i18n/message"); // 하위경로
        // 메세지 캐싱시간
        messageSource.setCacheSeconds(10);  // 왜함?
        //기본 인코딩 설정
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(messageSource());
    }
}
