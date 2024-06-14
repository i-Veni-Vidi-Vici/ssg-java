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

        // 원래는 log~return까지 try~catch를 해야 한다

        log.info("GET /errorsome");

        if(true)
            throw new RuntimeException("고기 에러입니다");

        return "result";
    }

    @ExceptionHandler(Exception.class) // 예외별로 상세하게 적는게 가능하다
    public String exception(Exception e, Model model) {
        log.error(e.getMessage());

        model.addAttribute("message", "고기가 상했습니다");
        return "error"; // forward처리 하는거다, 위에서 에러가 나왔어?? 그럼 여기서 처리한다
    }
}

