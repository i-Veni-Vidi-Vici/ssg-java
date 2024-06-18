package com.sh._04_exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @GetMapping("/errorsome")
    public String errorsome(){
        log.info("GET /errorsome");
        if(true)
            throw new RuntimeException("🥞🥞🥞");
        return "result";
    }

    /**
     * 특정 컨트롤러 하위에서 던져진 예외클래스별로 @ExceptionHandler를 작성할 수 있다.
     */
    @ExceptionHandler(Exception.class) // 모든 예외를 이거 하나로 처리한다는 의미
    public String exception(Exception e, Model model) {
        log.error(e.getMessage()); // 예외스택을 로그로 확인
        model.addAttribute("message", "핫케이크가 상했습니다..ㅠ");
        return "error"; // error는 forward처리
    }
}
