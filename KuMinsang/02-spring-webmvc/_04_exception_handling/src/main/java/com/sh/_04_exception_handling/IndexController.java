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
            throw new RuntimeException("🦄🦄🦄🦄🦄");
        return "result";
    }

    /**
     * 특정 컨트롤러 하위에서 던져진 예외만 처리
     *
     * @param e
     * @param model
     * @return
     */

    @ExceptionHandler(Exception.class)
    public String exception(Exception e , Model model){
        log.error(e.getMessage());
        model.addAttribute("message", "유니콘이 달려갑니다 힝");
        return "error";
    }
}
