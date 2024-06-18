package com.sh._04_exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 전체 예외를 대상으로 하는 예외핸들러
     * - 구체적인 예외핸들러가 없다면, 이 핸들러를 사용한다.
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, Model model) {
        log.info("@ControllerAdvice#exceptionHandler");
        log.error(e.getMessage(), e); // 예외로깅
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    /**
     * 특정타입별로 예외 처리
     * - 구체적인 예외타입과 일치할때 실행되는 핸들러
     * - @ExceptionHandler(Exception.class)보다 우선처리된다.
     * @param e
     * @param model
     * @return
     */

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(Exception e, Model model) {
        log.info("@ControllerAdvice#illegalArgumentExceptionHandler");
        log.error(e.getMessage(), e); // 예외로깅
        model.addAttribute("message", "입력값이 유효하지 않습니다: "+e.getMessage());
        return "error";
    }
}
