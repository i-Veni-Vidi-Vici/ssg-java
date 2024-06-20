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
@Slf4j
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/expression")
    public void expression(Model model) {
        model.addAttribute("member",new Member(1L,"홍길동",33, LocalDate.now()));
        model.addAttribute("text","Hello world <mark> Hello Thymeleaf</mark>");
        // return "html"이 없네?? 그럼 thymeleaf/expression으로 된 html파일을 찾겠네??

    }

    @GetMapping("/statement")
    public void statement(Model model) {
        model.addAttribute("num", 123);
        model.addAttribute("str", "바나나");

        model.addAttribute("members", List.of(
                new Member(1L,"홍길동",33,LocalDate.now()),
                new Member(2L,"신사임당",44,LocalDate.now()),
                new Member(3L,"이순신",55,LocalDate.now())

        ));
    }

    @GetMapping("/etc")
    public void etc(Model model) {
        model.addAttribute("num", 123);
        model.addAttribute("str", "바나나");

        model.addAttribute("pageCriteria",new PageCriteria());

        model.addAttribute("members", List.of(
                new Member(1L,"홍길동",33,LocalDate.now()),
                new Member(2L,"신사임당",44,LocalDate.now()),
                new Member(3L,"이순신",55,LocalDate.now())
        ));

        model.addAttribute("memberMap", Map.of(
                "honggd",new Member(1L,"홍길동",33,LocalDate.now()),
                "sinsa",new Member(2L,"신사임당",44,LocalDate.now()),
                "leess",new Member(3L,"이순신",55,LocalDate.now())
        ));

        model.addAttribute("member",new Member(1L,"세종대왕",17, LocalDate.now()));
    }

    @GetMapping("/fragment")
    public void fragment(Model model) {
        model.addAttribute("foo","FOO");
        model.addAttribute("bar","BAR");
    }

    @GetMapping("/page/{id}")
    public String page(@PathVariable int id, Model model)
    {
        log.debug("GET/page/{}",id);

        model.addAttribute("id",id);
        return "/thymeleaf/page";
    }

}
