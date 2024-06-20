package com.sh._01_request_mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    int c;
//    @RequestMapping("/")
//    @ResponseBody
//    public String main() {
//        return "<h1>Helloworld</h1>";
//    }
    // 위 코드를 주석 처리하면 localhost:8080/app/에서도 localhost:8080/app/index.html과 똑같이 나온다
}
