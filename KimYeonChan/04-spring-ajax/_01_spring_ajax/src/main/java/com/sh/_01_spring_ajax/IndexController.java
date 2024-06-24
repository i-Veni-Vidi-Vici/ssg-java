package com.sh._01_spring_ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {
    @GetMapping(value = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환 객체를 직접 Http 응답 메세지 본문에 작성하라.
    public String first1(@RequestParam String username) {
        log.debug("username:{}", username);
        return "meat!!! %s".formatted(username); // viewName 이 아니라 응답할 데이터 그 자체
    }

    @PostMapping("/first")
    @ResponseBody
    public String first2(@RequestParam String username) {
        log.debug("username:{}", username);
        return "meat!!! %s 맛있음?".formatted(username);
    }
}
