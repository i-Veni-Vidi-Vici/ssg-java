package com.sh._01_spring_ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {

    @GetMapping(value = "/first", produces = "text/pain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메시지 본문(body)에 작성하라는 의미
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "%s, 잘 지내니..? 🍶🍾🍷🍸🍹🍺🥂🥃 술 마시자ㅎㅎ".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체를 의미한다.
    }

    @PostMapping(value = "/first", produces = "text/pain; charset=UTF-8")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메시지 본문(body)에 작성하라는 의미
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "%s, 잘 지내니..? 🍕🍔🍟🌭🍿🍦 이제 패스트푸드로 해장하자^^".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체를 의미한다.
    }
}
