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

    // 인터셉터 등록하는 메서드
    // 여기에다가 우리가 만든 객체를 등록해야함.

    /**
     *
     * 작성한 interceptor 빈과 적용할 url을 InterceptorRegistry에 등록해야 한다.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /* : /a, /xyz 매칭, /a/b 매칭이 안됨. (텍스트 매칭)
        // /** : /a, /xyz, /a/b, /a/b/c 모두 매칭. **는 0개이상의 디렉토리와 매칭

        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**") // 모든 요청 모든 url
                .excludePathPatterns("/css/**", "/js/**", "images/**") // 정적자원제외
                .excludePathPatterns("/error"); // 에러페이지 포워딩도 제외

        registry.addInterceptor(stopwatchInterceptor)
                .addPathPatterns("/test/interval"); // 어떤 url 요청의 인터셉터를 쓸까? 하고 등록하는거임
    }
}
