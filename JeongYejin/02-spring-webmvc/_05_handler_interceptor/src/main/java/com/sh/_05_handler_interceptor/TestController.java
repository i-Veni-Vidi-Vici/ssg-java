package com.sh._05_handler_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/test") // /app/test
public class TestController {
    @GetMapping
    public void test(Model model) { // Model은 viewName과 attribute조합
        log.info("GET /test 핸들러 호출되었다!"); // (2) GET /test 핸들러 호출되었다!
        model.addAttribute("message", "🥞🥞🥞");
    }

    @GetMapping("/interval") // /app/test/interval
    public String interval(Model model) throws InterruptedException {
        log.info("GET /test/interval 핸들러 호출되었다!");
        Thread.sleep(2000);
        model.addAttribute("message", "🍟🍟🍟");
        // 핸들러를 호출하기 전에 예외처리를 스프링이 대신함
        return "test"; // 이건 응답으로 html을 줄 때 쓰는 거
    }
}