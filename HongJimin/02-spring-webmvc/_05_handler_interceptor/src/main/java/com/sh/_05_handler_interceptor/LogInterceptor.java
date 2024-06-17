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
 *
 * 1. preHandle : 실제 핸들러 호출 전에 수행,
 *     - return true인 경우만, 핸들러와 연결됨
 *     - return false를 통해 핸들러 호출을 막을 수도 있다.
 * 2. postHandle : 핸들러 호출 이후 수행
 * 3. afterCompletion : view단 작업 완료 후에 수행
 *
 *✨여기서는 세개 다 햇지만 나중에는 필요한 것만 골라서 하면 됨! 세개의 메소드가 default이기 때문!
 */
@Component // 빈으로 등록을 해줘야 함
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 실제 요청 URL을 출력
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.info("{} {}로 요청이 시작되었습니다!~", method, uri); // GET /app/test
        return true; //true여야 다음 핸들러가 실행됨, true가 아니면 끝이다
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { // ✨핸들러 어댑터가 반환한 modelandview에 접근이 가능함
        log.info("핸들러 요청을 완료했습니다~ ModelAndView = {}", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("응답메세지를 발송합니다!~ ");
    }
}
