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

    /**
     * 특정 컨트롤ㄹ러 하위에서 던져진 예외 클래스 별로 @ExceptionHandler 를 작성할 수 있다.
     */
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("message", "비상!비상!우이잉이이ㅣ이이이이이이");
        return "error";
    }
}
