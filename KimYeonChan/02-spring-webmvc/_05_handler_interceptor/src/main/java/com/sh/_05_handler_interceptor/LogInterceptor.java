package com.sh._05_handler_interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * handlerInterceptor
 * - 핸들러 처리와 관련해서 특정 위치에서 작업을 수행할 수 있다.
 * 1. preHandle
 *   - 실제 핸들러 호출전에 수행.
 *   - return true 인 경우만 핸들러와 연결된다.
 *   - return false 를 통해 호출을 막을수도 있다.
 * 2. postHandle
 *   - 핸들러 호출 이후 수행
 * 3. afterCompletion
 *   - view 단 작업 완료 후 수행
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 실제 요청 URL 을 출력
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("{} {}로 요청이 시작 되었습니다...", method, uri); // GET /app/test
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("핸들러 요청을 완료했습니다... ModelAndView = {}", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("응답 메세지를 발송합니다.");
    }
}
