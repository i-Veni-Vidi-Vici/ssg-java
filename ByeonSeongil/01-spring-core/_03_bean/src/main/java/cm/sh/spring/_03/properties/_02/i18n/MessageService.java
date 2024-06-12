package cm.sh.spring._03.properties._02.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.time.LocalDate;
import java.util.Locale;

@RequiredArgsConstructor
public class MessageService {
    private final MessageSource messageSource;

    public String welcome(Locale locale) {
        return messageSource.getMessage("message.welcome", null, locale);
    }

    public String greeting(Locale locale, String name) {
        return messageSource.getMessage("message.greeting", new Object[]{name, LocalDate.now()}, locale);
    }
}
