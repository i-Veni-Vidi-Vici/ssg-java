package com.sh._04_exception_handling;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 컨트롤러 뒤에서 실행 후에, 예외가 발생하면 여기 클래스로 넘어오도록 하는 어노테이션
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 전체 예외를 대상으로 하는 예외 핸들러
     * - 구체적인 예외핸들러가 없다면, 이 핸들러를 사용함
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, Model model) {
        log.info("@ControllerAdvice#exceptionHandler");
        log.error(e.getMessage(), e); // 예외 로깅
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    /**
     * 특정 타입 별로 예외처리하는 예외 핸들러
     * - 구체적인 예외 타입과 일치할 때, 실행되는 핸들러
     * - @ExceptionHandler(Exception.class)보다 우선 처리 된다.
     *
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(Exception e, Model model) {
        log.info("@ControllerAdvice#illegalArgumentExceptionHandler");
        log.error(e.getMessage(), e); // 예외 로깅
        model.addAttribute("message", "입력값이 유효하지 않습니다 : " + e.getMessage());
        return "error";
    }
}
