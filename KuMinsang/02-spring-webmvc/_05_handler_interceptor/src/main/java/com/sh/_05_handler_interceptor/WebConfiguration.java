package com.sh._05_handler_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;
    @Autowired
    private StopWatchInterceptor stopWatchInterceptor;
    /**
     * 작성한 interceptor Bean과 적용한  url을 InterceptorRegistry에 등록해야 한다.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /* : /, /a, /b, /xyz 매칭, /a/b 매칭이 안됨 (텍스트 매칭)
        // /** : /, /a, /xyz, /a/b, /a/b/c 모두 매칭. **는 0개 이상의 디렉토리와 매칭 (디렉토리 매칭)
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**/*")
                .excludePathPatterns("/css/**", "/js/**", "/images/**") //정적자원 제외
                .excludePathPatterns("/error");

        registry.addInterceptor(stopWatchInterceptor).addPathPatterns("/test/interval");
    }
}
