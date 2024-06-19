package com.sh._04_exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/other")
@Slf4j
public class OtherController {
    @GetMapping("/errorsome")
    public void errorsome(){
        log.info("GET /other/errorsome");
        if (true) {
            throw new RuntimeException("🍕🍕🍕");
        }
    }

    @GetMapping("/foo")
    public void foo(@RequestParam int value){ // /other/foo?value=-100 value는 -100을 읽는다
        log.info("GET /other/foo");
        if (value <= 0) {
            throw new IllegalArgumentException("value는 0 또는 음수일 수 없습니다. : " + value);
            // 이 예외를 처리하는 곳은 GlobalExceptionHandler의 @ExceptionHandler(IllegalArgumentException.class)

        }
    }
}
