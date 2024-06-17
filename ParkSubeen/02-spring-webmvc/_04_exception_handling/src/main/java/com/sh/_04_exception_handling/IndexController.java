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

    /**
     * 특정 컨트롤러 하위에서 던져진 예외클래스 별로 @ExceptionHandler를 작성할 수 있다.
     * error가 발생하면 발생한 곳에서 자동으로 forward 처리
     * @param e
     * @param model
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        log.error(e.getMessage(), e); // 예외스택을 로그 확인
        model.addAttribute("message", "치즈가 상했습니다...");
        return "error";
    }
}
