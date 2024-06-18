package com.sh._05_handler_interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * HandlerInterceptor
 * - 핸들러 처리와 관련해서 특정위치에서 작업을 수행할 수 있다.
 * <p>
 * 1. preHandle : 실제 핸들러 호출전에 수행.
 * - return true인 경우만 핸들러와 연결된다.
 * - return false를 통해 핸들러 호출을 막을 수도 있다.
 * 2. postHandle : 핸들러 호출 이후 수행
 * 3. afterCompletion : view단 작업 완료 후에 수행
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    // 인터페이스 메소드가 default로 정의되어있어서 오버라이드하지 않아도 에러가 뜨지 않는 것을 볼 수 있다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 실제 요청 URL을 출력
        String uri = request.getRequestURI(); // /app/test
        String method = request.getMethod(); // GET
        log.info("{} {}로 요청이 시작되었습니다...", uri, method); // (1) /app/test GET로 요청이 시작되었습니다...
        return true; // true반환해야 Controller로 넘어간다
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("핸들러 요청을 완료했습니다...ModelAndView = {}", modelAndView); // (3) 핸들러 요청을 완료했습니다...ModelAndView = ModelAndView [view="test"; model={message=🥞🥞🥞}]
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("응답메세지를 발송합니다...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex); // (4) 응답메세지를 발송합니다...
    }
}
