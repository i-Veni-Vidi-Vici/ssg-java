package com.sh._05_handler_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping
    public void test(Model model) {
        log.info("GET /test ");

        model.addAttribute("message", "돋보기돋보기");
    }

    @GetMapping("/interval")
    public String interval(Model model) throws InterruptedException {
        log.info("GET /test/interval 핸들러 호출성격");
        Thread.sleep(2000);

        model.addAttribute("message", "안녕안녕안녕");

        return "test";
    }
}
