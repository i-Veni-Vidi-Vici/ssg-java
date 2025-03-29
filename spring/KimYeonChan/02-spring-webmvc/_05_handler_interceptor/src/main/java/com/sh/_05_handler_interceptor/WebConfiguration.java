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
    private StopWatchInterceptor stopWatchInterceptor;

    /**
     * 작성한 interceptor 빈과 적용할 url 을 InterceptorRegistry 에 등록해야 한다.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /*: /, /a, /b, /zxy 매칭 됨, /a/b 매칭 안됨
        // /**: /, /a, /b, /zxy, /a/b, /a/b/c 매칭 됨. 0개 이상의 디렉토리와 매칭 (디렉토리 매칭)
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**, /js/**, /images/**") // 정적자원 제외
                .excludePathPatterns("/error/**"); /// 에러페이지 포워딩도 제외

        registry.addInterceptor(stopWatchInterceptor)
                .addPathPatterns("/test/interval");
    }
}
