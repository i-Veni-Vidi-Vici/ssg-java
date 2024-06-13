package com.sh._01_request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/*")
@Slf4j
public class OrderController {

    /**
     * 클래스레벨의 @RequestMapping과 메소드레벨의 @RequestMapping path 값을 연결해 url을 매핑시킨다.
     * 중복된 url의 관리가 수월하다.
     * 클래스레벨의 *(와일드카드)와 메소드레벨의 path
     */
    @GetMapping("/regist")
    public String registOrder(Model model) {
        log.info("GET /order/regist 요청!");
        model.addAttribute("message", "주문 등록 폼을 요청합니다...");
        return "mappingResult";
    }
    @PostMapping("/regist")
    public String registOrder2(Model model) {
        log.info("POST /order/regist 요청!");
        model.addAttribute("message", "주문 등록을 요청합니다...");
        return "mappingResult";
    }
    @RequestMapping
    public String defaultOrder(Model model) {
        log.info("/order/* 요청!");
        model.addAttribute("message", "존재하지 않는 주문 요청입니다...");
        return "mappingResult";
    }
    @GetMapping({"/modify", "/delete"})
    public String modifyOrderDeleteOrder(Model model) {
        log.info("GET /order/modify, GET /order/delete 요청!");
        model.addAttribute("message", "주문 수정/삭제폼을 요청합니다...");
        return "mappingResult";
    }

    @GetMapping("/detail/{id}")
    public String findOrderById(Model model, @PathVariable Long id) {
        log.info("GET /order/detail/{} 요청!", id);
        model.addAttribute("message", id + "번 주문 상세보기를 요청합니다...");
        return "mappingResult";
    }
}
