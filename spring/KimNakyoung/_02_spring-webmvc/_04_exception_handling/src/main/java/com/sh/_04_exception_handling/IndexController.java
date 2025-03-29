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
        if(true)
            throw new RuntimeException("🥩🥩🥩🥩");
        return "result";
    }

    /**
     * 특정 컨트롤러 하위에서 던져진 예외클래스 별로 @ExceptionHandler를 작성할 수 있다.
     *
     */
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage(), e); // 예외스택을 로그 확인
        model.addAttribute("message", "고기가 상했습니다...");
        return "error";
    }

}
