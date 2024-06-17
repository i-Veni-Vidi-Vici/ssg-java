package com.sh._05_handler_interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class StopWatchInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("시작시각을 체크합니다...");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime); // Model 을 사용할 수 없으므로 Request 의 속성으로 직접 저장

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("종료시각을 체크합니다.");
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        log.info("소요시간은: " + interval + "ms");

        // Model 을 읽거나 쓰기할 수 있다.
        modelAndView.addObject("interval", interval);
    }
}