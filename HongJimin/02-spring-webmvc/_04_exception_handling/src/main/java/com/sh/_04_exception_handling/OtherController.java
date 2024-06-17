package com.sh._04_exception_handling;

import jdk.jfr.Registered;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/other")
@Slf4j
public class OtherController {
    @GetMapping("/errorsome")
    public void errorsome() {
        log.info("GET /other/errorsome");
        if(true)
            throw new RuntimeException("🥕🥕🥕"); // 커스텀 예외 클래스를 작성해도 됨
    }

    @GetMapping("/foo")
    public void foo(@RequestParam int value){
        log.info("GET /other/foo");
        if(value <= 0 )
            throw new IllegalArgumentException("value는 0 또는 음수일 없습니다. : " + value);
    }
}
