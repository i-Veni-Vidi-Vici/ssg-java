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

//    @GetMapping(path = "/first", produces = "text/plain; charset=UTF-8")
    // produces = "text/plain; charset=UTF-8"
    // => servlet에서 response.setContentType("text/html");설정하는 것에 해당
    @GetMapping("/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http응답 메세지 본문(body)에 작성하라
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍠🍠🍠 %s, 잘 지내니? 너에게 고구마를 보낸다.".formatted(username); // ViewName이 아니라 응답할 데이트 그 잡채
        // 비동기때는 실제로는 데이터만 보내주면 된다고!
    }

    @PostMapping("/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http응답 메세지 본문(body)에 작성하라
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍠🍠🍠 %s, 잘지내니? 저번 고구마는 어땟니? 이번엔 호박고구마야.".formatted(username); // ViewName이 아니라 응답할 데이트 그 잡채
        // 비동기때는 실제로는 데이터만 보내주면 된다고!
    }
}
