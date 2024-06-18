package com.sh._04_exception_handling;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 이건 전체를 예외를 대상으로 하는 예외핸들러
     * - 구체적인 예외 핸들러가 없다면, 이 핸들러를 사용한다
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(Exception.class) // 메소드 레벨
    public String exceptionHandler (Exception e, Model model)
    {
        log.info("@ControllerAdvice#exceptionHandler입니다");
        log.error(e.getMessage() ,e); // 예외로깅
        model.addAttribute("message",e.getMessage());
        return "error";
    }

    //이건 구체적인 예외핸들러

    /**
     * 특정 타입별로 예외처리
     * - 구체적인 예외타입과 일치할 떄 실행되는 핸들러
     * - @ExceptionHandler(Exception.class) 이거보다 우선으로 한다
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class) // 메소드 레벨
    public String illegalArgumentException (Exception e, Model model)
    {
        log.info("@IllegalArgumentException#exceptionHandler입니다");
        log.error(e.getMessage() ,e); // 예외로깅
        model.addAttribute("message","입력값이 유효하지 않습니다" + e.getMessage());
        return "error";
    }
}
