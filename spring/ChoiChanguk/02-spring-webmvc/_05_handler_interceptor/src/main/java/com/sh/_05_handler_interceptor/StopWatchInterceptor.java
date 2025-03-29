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
    // 시작할때 pre, 끝나고 나올때 post


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("시작시각을 체크합니다....prehandler");
        long startTime=System.currentTimeMillis();

        // 지금 여기서는 model을 가져올 방법이 없다 // Model을 사용할 수 없으므로 request에 속성을 직접 저장
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("종료시각을 체크합니다");

        long endTime=System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        long interval=endTime-startTime;

        log.info("소요 시간은, {}ms 입니다",interval);

        // Model 읽기 쓰기 가능, 왜냐 갓다가 와서 ModelAndView가 있으니깐
        modelAndView.addObject("interval",interval);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
