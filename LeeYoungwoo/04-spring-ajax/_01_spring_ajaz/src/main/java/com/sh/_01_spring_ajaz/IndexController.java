package com.sh._01_spring_ajaz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {

    @GetMapping(path = "/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라. -> 이게 없으면 return의 고기.html을 찾으려고 할것임
    public String first(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🍖🍖🍖 %s, 잘지내니?".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
        // 원래는 view이름을 적어줬지만 이제는 html이 바뀌지 않기 때문에
    }

    @PostMapping("/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문(body)에 작성하라. -> 이게 없으면 return의 고기.html을 찾으려고 할것임
    public String first2(@RequestParam String username) {
        log.debug("username = {}", username);
        return "🥩🥩🥩 %s, 이번에는 소고기를 보낼게...".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
        // 원래는 view이름을 적어줬지만 이제는 html이 바뀌지 않기 때문에
    }
}
