package com.sh._01_request_mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    int a;
//    @RequestMapping("/")
//    @ResponseBody // 스트링을 응답 메세지에 바로 받도록 하는 어노테이션
//    public String main() {
//        return "<h1>Helloworld</h1>";
//    }
}
