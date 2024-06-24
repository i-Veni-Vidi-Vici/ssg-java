package com.sh._01_spring_ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {


    @GetMapping(path = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라.
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍖🍖🍖 %s, 잘지내니? 너에게 고기를 보낸다.".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
    }

    @PostMapping(path = "/first", produces = "text/plain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라.
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🥩🥩🥩 %s, 잘지내니? 저번 고기는 어땠니? 이번엔 소고기야".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
    }
}
