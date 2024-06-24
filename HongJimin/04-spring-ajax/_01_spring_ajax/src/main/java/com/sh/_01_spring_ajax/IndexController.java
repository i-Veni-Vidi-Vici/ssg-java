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
    @ResponseBody // 이 핸들러의 반환 객체를 직접 http응답 메세지 본문(body)에 작성하라.
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🥑🥑🥑 %s,  잘 지내니? 아보카도 먹을래? ".formatted(username); // viewName이 아니라 응답할 데이터 그 자체
    }

    @PostMapping(value = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환 객체를 직접 http응답 메세지 본문(body)에 작성하라.
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🥯🥐🥨 %s,  잘 지내니? 빵도 먹을래? 냠  ".formatted(username); // viewName이 아니라 응답할 데이터 그 자체
    }
}
