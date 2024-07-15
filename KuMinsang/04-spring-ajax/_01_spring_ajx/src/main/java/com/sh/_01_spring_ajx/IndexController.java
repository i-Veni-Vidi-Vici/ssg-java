package com.sh._01_spring_ajx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/first")
    @ResponseBody   //이 핸들러의 반환객체를 직접 hhtp 응답 메시지 본문 (body)에 작성하라
    public String first(@RequestParam String username){
        log.debug("username = {}", username);
        return "💖💖💖 호우!";   //ViewName이 아니라 응답할 데이터 그 자체임을 알려줘야함 @ResponseBody로 처리
    }

    @PostMapping("/first")
    @ResponseBody   //이 핸들러의 반환객체를 직접 hhtp 응답 메시지 본문 (body)에 작성하라
    public String first2(@RequestParam String username){
        log.debug("username = {}", username);
        return "💖💖💖 포스트!!!";   //ViewName이 아니라 응답할 데이터 그 자체임을 알려줘야함 @ResponseBody로 처리
    }
}
