package com.sh._05_handler_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public void test(Model model) {
        log.info("GET /test 핸들로 호출!");
        model.addAttribute("message", "🍳🍳🍳");
    }

    @GetMapping("/interval")
    public String interval(Model model) throws InterruptedException {
        log.info("GET /test/interval 핸들러 호출!");
        Thread.sleep(2000);
        model.addAttribute("message", "🍟🍟🍟");
        return "test";
    }
}
