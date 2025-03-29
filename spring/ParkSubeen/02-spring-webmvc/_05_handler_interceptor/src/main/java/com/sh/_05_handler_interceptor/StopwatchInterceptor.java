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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("시작시간을 체크합니다...");
        long startTime = System.currentTimeMillis();
        // 핸들러를 호출한 이후에만 Model을 사용할 수 있다. (현재는 핸들러 호출 전)
        request.setAttribute("startTime",startTime); // Model을 사용할 수 없으므로 request에 속성으로 직접 저장!
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("종료시각을 체크합니다...");
        long endTime = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        long interval = endTime - startTime;
        log.info("소요시간 : {} ms: ", interval);

        // Model을 읽거나 쓰기할 수 있다. (Handler를 갔다왔기 때문)
        modelAndView.addObject("interval", interval);
    }
}
