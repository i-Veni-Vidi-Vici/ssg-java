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
    public void test(Model model){
        log.info("GET /test 핸들러 호출!");
        model.addAttribute("message","🎃🎃🎃");
    }

    @GetMapping("/interval")
    public String interval(Model model) throws InterruptedException {
        log.info("GET /test/interval 핸들러 호출!");
        Thread.sleep(2000); // 왜냐면 이건 빠르니까  // 예외는 던져주세영 처리 해도되긴하는데 스프링이 현재 예외처리를 해주고있어서 안멈춤
        model.addAttribute("message","🍕🍕🍕");
        return "test"; // 왜 이거해야 출력되나요?
    }

}
