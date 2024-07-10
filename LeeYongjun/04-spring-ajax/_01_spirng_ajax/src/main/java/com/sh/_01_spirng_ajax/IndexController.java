package com.sh._01_spirng_ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {
    @GetMapping(value = "/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문에 작성하라.
    public String first(@RequestParam String username){
        return "😍😍😍 %s, 잘지내니? 너에게 고기를 보낸다.".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
    }

    @PostMapping(value = "/first")
    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메세지 본문에 작성하라.
    public String first2(@RequestParam String username){
        return "😊😊😊 %s, 잘지내니? 저번 고기는 어떘니? 이번엔 소고기야".formatted(username); // ViewName이 아니라 응답할 데이터 그 자체
    }
}
