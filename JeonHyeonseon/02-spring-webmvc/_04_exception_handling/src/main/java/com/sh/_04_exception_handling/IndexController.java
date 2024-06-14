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

    @ExceptionHandler(Exception.class) // 모든 예외를 이거 하나로 처리한다는 의미
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("message", "핫케이크가 상했습니다..ㅠ");
        return "error"; // error는 forward처리
    }
}
