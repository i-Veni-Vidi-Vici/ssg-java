package com.sh._05_handler_interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class StopwatchInterceptor implements HandlerInterceptor {

    // 오버라이드 ctrl + o
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("시작시간을 체크합니다.");
        long startTime = System.currentTimeMillis();
        // 저장할 곳이 없다. 그리고 아직 model 못씀 model은 핸들러 호출된 이후에 쓸 수 있음
        request.setAttribute("startTime", startTime); // Model을 사용할 수 없으므로 request에 속성으로 직접 저장!
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("종료시각을 체크합니다...");
        long endtime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        long interval = endtime - startTime;
        log.info("소요시간 : {} ms: ", interval);
        // 여긴 모델 됩니다. 왜냐면 핸들러 갔다 와서 가능 !

        // Model을 읽거나 쓰기할 수 있다.
        modelAndView.addObject("interval", interval);

    }
}
