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
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라
    public String first(@RequestParam String username) {
        log.debug("username = {}",username);
        return "%s야 잘 지내라".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체이다, 그니까 html이 아니라, html 데이터를 실행하라
    }

    @PostMapping(value = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라
    public String first2(@RequestParam String username) {
        log.debug("username = {}",username);
        return "%s 내일은 토요일이다".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체이다, 그니까 html이 아니라, html 데이터를 실행하라
    }
}
