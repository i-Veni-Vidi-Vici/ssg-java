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
    public String errorsome() {

        log.info("GET /errorsome");
        if (true)
            throw new RuntimeException("🍗🍗🍗🍗🍗🍗"); // 여기서 에러가 던져지면  @ExceptionHandler의 메소드가 실행됨
        return "result";
    }

    @ExceptionHandler(Exception.class) // 어떤 예외에 관한 건지
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("message", "고기가 상했습니다😪");
        return "error";
    }
}
