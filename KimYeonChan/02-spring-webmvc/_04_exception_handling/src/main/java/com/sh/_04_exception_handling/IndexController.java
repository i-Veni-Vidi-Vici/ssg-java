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
        log.error("GET /errorsome");
        if (true)
            throw new RuntimeException("오류!!!!");
        return "result";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("message", "비상!비상!우이잉이이ㅣ이이이이이이");
        return "error";
    }
}
