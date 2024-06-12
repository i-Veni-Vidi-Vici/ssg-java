package com.sh.spring._03.properties._02.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;

import java.time.LocalDate;
import java.util.Locale;

@RequiredArgsConstructor // final이기 때문에 @RequiredArgsConstructor 작성하면 알아서 만들어준다.
public class MessageService {
    private final MessageSource messageSource; // final이기 때문에 객체생성과 동시에 필드를 만들어줘야함.

    public String welcome(Locale locale) {
        return messageSource.getMessage("message.welcome", null, locale);
    }

    public String greeting(Locale locale, String name) {
        return messageSource.getMessage("message.greeting", new Object[]{name, LocalDate.now()}, locale);
    }
}
