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
        if(true) // 무조건 예외 발생 처리
            throw new RuntimeException("🧀🧀🧀");
        return "result";
    }

    // error가 발생하면 발생한 곳에서 자동으로 forward 처리
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("message", "치즈가 상했습니다...");
        return "error";
    }
}
