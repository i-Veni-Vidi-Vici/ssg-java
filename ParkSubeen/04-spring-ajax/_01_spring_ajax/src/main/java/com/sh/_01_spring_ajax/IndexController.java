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

    @GetMapping("/first") // produces = "text/plain; charset=UTF-8" 을 자동으로 해주고 있어서 생략 가능
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라.
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍨🍨🍨 %s, 잘 지내니? 너어게 빙수를 보낸다.".formatted((username)); // ViewName이 아니라 응답할 데이터 그 자체
    }

    @PostMapping(path = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라.
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍦🍦🍦 %s, 잘 지내니? 저번 빙수는 어땠니? 이번엔 아이스크림이야".formatted((username)); // ViewName이 아니라 응답할 데이터 그 자체
    }
}
