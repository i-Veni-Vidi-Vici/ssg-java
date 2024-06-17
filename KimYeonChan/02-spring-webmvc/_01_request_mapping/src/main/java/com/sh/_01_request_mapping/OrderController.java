package com.sh._01_request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 클래스레벨의 @RequestMapping 과 메소드 레벨의 @RequestMapping 의 path 값을 연결해 url 을 매핑시킨다.
 * - 중복된 url 의 관리가 수월해진다.
 * - 클래스 레벨의 *(와일드 카드)와 메소드 레벨의 path 없는 @RequestMapping 을 사용하면, 기본 url 처럼 사용할 수 있다.
 */
@Controller
@RequestMapping("/order/*")
@Slf4j // Simple Logging Facade For Java
public class OrderController {
    @GetMapping("/regist")
    public String registOrder(Model model) {
        log.info("GET /order/regist 요청!");
        model.addAttribute("message", "주문 등록 폼을 요청합니다.");
        return "mappingResult";
    }
    @PostMapping("/regist")
    public String registOrder2(Model model) {
        log.info("POST /order/regist 요청!");
        model.addAttribute("message", "주문 등록을 요청합니다.");
        return "mappingResult";
    }

    /**
     * 하나의 핸들러에서 여러 url 을 처리할 수 있다.
     * 반대는 불가능하다.
     */
    @GetMapping({"/modify", "/delete"})
    public String modifyOrDeleteOrder(Model model) {
        log.info("POST /order/modify, GET /order/delete 요청!");
        model.addAttribute("message", "주문 수정/삭제폼을 요청합니다.");
        return "mappingResult";
    }

    /**
     * 경로변수
     * - @RequestMapping 의 path 속성 중 {변수명}에 해당하는 부분을 핸들러의 매개변수 사용할 수 있다.
     * - 경로변수와 매개변수명이 같아야 한다.
     * - 다른 경우 @PathVariable("변수명") 과 같이 작성해야 한다.
     * - 여러개도 가능하다.
     * - 필요한 경우 형변환 처리도 지원한다.
     */
    @GetMapping("/detail/{orderId}")
    public String findOrderById(Model model, @PathVariable("orderId") Long id) {
        log.info("GET /order/detail/{}", id);
        model.addAttribute("message", id + "번 주문 상세보기를 요청합니다.");
        return "mappingResult";
    }

    @RequestMapping
    public String defaultOrder(Model model) {
        log.info("GET /order/* 요청!");
        model.addAttribute("message", "존재하지 않는 주문 요청입니다.");
        return "mappingResult";
    }
}
