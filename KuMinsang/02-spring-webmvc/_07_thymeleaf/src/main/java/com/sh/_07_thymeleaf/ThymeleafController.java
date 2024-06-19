package com.sh._07_thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/thymeleaf")
@Slf4j
public class ThymeleafController {
    @GetMapping("/expression")
    public void expression(Model model){
        model.addAttribute("member", new Member(1L, "홍길동", 33, LocalDate.now()));
        model.addAttribute("text", "this is honggildong thymeleaf");
    }

    @GetMapping("/statement")
    public void statement(Model model){
        model.addAttribute("num", 123);
        model.addAttribute("str", "바나나");

        model.addAttribute("members", List.of(
                new Member(1L, "홍길동", 33, LocalDate.now()),
                new Member(2L, "이순신", 53, LocalDate.now()),
                new Member(3L, "임꺽정", 13, LocalDate.now())
        ));
    }

    @GetMapping("/etc")
    public void etc(Model model){
        model.addAttribute("num", 123);
        model.addAttribute("str", "바나나");

        model.addAttribute("pageCriteria", new PageCriteria(1, 10, 3));

        model.addAttribute("member", new Member(1L, "봉고캣", 99, LocalDate.now()));

        model.addAttribute("members", List.of(
                new Member(1L, "홍길동", 33, LocalDate.now()),
                new Member(2L, "이순신", 53, LocalDate.now()),
                new Member(3L, "임꺽정", 13, LocalDate.now())
        ));
        model.addAttribute("memberMap", Map.of(
                "sinamon", new Member(1L, "시나몬롤", 33, LocalDate.now()),
                "kuromi", new Member(2L, "쿠로미", 53, LocalDate.now()),
                "pikachu", new Member(3L, "피카츄", 13, LocalDate.now())
        ));
    }

    @GetMapping("/fragment")
    public void fragment(Model model){
        model.addAttribute("foo", "FOO");
        model.addAttribute("bar", "BAR");
    }

    @GetMapping("/page/{id}")
    public String page(@PathVariable int id, Model model){
        log.debug("GET /page/{}", id);

        model.addAttribute("id", id);
        return "thymeleaf/page";
    }
}
