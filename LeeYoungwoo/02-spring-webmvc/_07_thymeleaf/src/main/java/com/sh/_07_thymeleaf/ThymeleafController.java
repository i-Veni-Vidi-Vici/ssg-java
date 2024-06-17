package com.sh._07_thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@Slf4j
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/expression")
    public void expression(Model model) {
        model.addAttribute("member", new Member(1L, "홍길동", 33, LocalDate.now()));
        model.addAttribute("text", "Hello world! <mark>Hello Thymelaf</mark>");
    }
}
