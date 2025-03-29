package com.sh._05_handler_intercepter;

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
    public void test(Model model){
        model.addAttribute("message","🤣🤣🤣");
        log.info("Get /test 핸들러 호출!");
    }

    @GetMapping("/interval")
    public String interval(Model model) throws InterruptedException {
        log.info("Get /test/interval 핸들러 호출!");
        Thread.sleep(2000);
        model.addAttribute("message","(●'◡'●)");
        return "test";
    }
}
