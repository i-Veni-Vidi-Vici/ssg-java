package com.sh._05_handler_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;
    @Autowired
    private StopwatchInterceptor stopwatchInterceptor;

    /**
     * 작성한 interceptor빈과 적용할 url을 InterceptorRegistry에 등록해야 한다.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /* : /, /a, /xyz 매칭, /a/b 매칭이 안됨. (텍스트 매칭)
        // /** : /, /a, /xyz, /a/b, /a/b/c 모두 매칭. **는 0개이상의 디렉토리와 매칭 (디렉토리 매칭)
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**") // 모든 요청
                .excludePathPatterns("/css/**", "/js/**", "/images/**") // 정적자원 제외
                .excludePathPatterns("/error"); // 에러페이지 포워딩도 제외

        registry.addInterceptor(stopwatchInterceptor)
                .addPathPatterns("/test/interval");
    }
}
