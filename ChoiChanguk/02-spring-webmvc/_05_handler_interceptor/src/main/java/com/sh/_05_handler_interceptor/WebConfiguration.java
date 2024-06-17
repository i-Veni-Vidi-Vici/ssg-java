package com.sh._05_handler_interceptor;

//web관련 설정을 등록한다

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
    // 여기에 우리가 만든 인터셉터를 등록해줘야 한다


    /**
     * 작성한 interceptor빈과 적용할 url을 InterceptorRegisty에 등록해야 한다
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /* 일 때, /, /a, /xyz 매칭된다, /a/b는 매칭 안됨, (텍스트 매칭)
        // /** 일 때, /, /a, /xyz, /a/b/c 매칭된다, **는 0개이상의 디렉토리와 매칭 (디렉토리 매칭)
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**") // 모든 요청
                .excludePathPatterns("/css/**","/js/**","/images/**")// 정적자원 제외
                .excludePathPatterns("/error"); // 에러페이지 포워딩도 제외


        registry.addInterceptor(stopWatchInterceptor)
                .addPathPatterns("/test/interval");
    }
}
