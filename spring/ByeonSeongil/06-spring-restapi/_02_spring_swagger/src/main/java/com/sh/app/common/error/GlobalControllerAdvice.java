package com.sh.app.common.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 전역 예외처리를 위한 AOP클래스
 * - 예외타입별로 예외 사후처리가 가능하다.
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException e) {
        // 예외로깅
        log.error(e.getMessage(), e);
        // 예외객체안의 default message 가져오기
        List<String> messages = new ArrayList<>();
        if(e.getBindingResult().hasErrors()) {
            e.getBindingResult().getAllErrors()
                    .forEach(error -> messages.add(error.getDefaultMessage()));
        }
        return ResponseEntity.badRequest().body(Map.of(
            "result", "입력값 오류",
            "messages", messages
        ));
    }
}
