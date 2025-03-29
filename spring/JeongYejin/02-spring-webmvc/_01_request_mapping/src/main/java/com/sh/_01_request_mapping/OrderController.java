package com.sh._01_request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 클래스 레벨의 @RequestMapping과 메소드레벨의 @RequestMappping의 path값을 연결해 url을 매핑시킨다.
 * - 중복된 url의 관리가 수월하다.
 * - 클래스레벨의 *(와일드카드)와 메소드레벨의 path없는 @RequestMapping을 사용하면, 기본 url처럼 처리할 수 있다.
 */
@Controller
@RequestMapping("/order/*")
@Slf4j // Simple logging Facade for Java
public class OrderController {
    @GetMapping("/regist")
    public String registOrder(Model model) {
        log.info("GET /order/regist 요청✨");
        model.addAttribute("message", "주문 등록 폼을 요청(GET)합니다.");
        return "mappingResult";
    }

    @PostMapping("/regist")
    public String registOrder2(Model model) {
        log.info("POST /order/regist 요청✨");
        model.addAttribute("message", "주문 등록을 요청(POST)합니다.");

        return "mappingResult";
    }

//    @PostMapping("/regist")
//    public String registOrder3(Model model) {
//        log.info("POST /order/regist 요청✨");
//        model.addAttribute("message", "주문 등록을 요청(POST)합니다.");
//
//        return "mappingResult";
//    }

    @RequestMapping
    public String defaultOrder(Model model) {
        log.info("/order/* 요청!");
        model.addAttribute("message", "존재하지 않는 주문 요청입니다...😫");
        return "mappingResult";
    }

    /**
     * 하나의 핸들러에서 여러 url을 처리할 수 있다. 반대는 불가능하다.
     * @param model
     * @return
     */

    @GetMapping({"/modify", "/delete"})
    public String modifyOrDeleteOrder(Model model) {
        log.info("GET /order/modify, GET /order/delete 요청!");
        model.addAttribute("message", "주문 수정/삭제폼을 요청합니다...");
        return "mappingResult";
    }

    /**
     * 경로변수
     * - @RequestMapping의 path속성 중 {변수명}에 해당하는 부분을 핸들러의 매개변수로 사용할 수 있다.
     * - 경로변수와 매개변수명이 같아야 한다.
     * - 다른 경우는 @PathVariable("변수명")와 같이 작성해주면 된다.
     * - 여러개도 가능하다.
     * @param model
     * @param id
     * @return
     */

    @GetMapping("/detail/{id}")
    public String findOrderById(Model model, @PathVariable Long id) {
        log.info("GET /order/detail/{} 요청!", id);
        model.addAttribute("message", id + "번 주문 상세보기를 요청합니다...");
        return "mappingResult";
    }

//    @GetMapping("/detail/{orderId}")
//    public String findOrderById2(Model model, @PathVariable("orderId") Long id) {
//        log.info("GET /order/detail/{} 요청!", id);
//        model.addAttribute("message", id + "번 주문 상세보기를 요청합니다...");
//        return "mappingResult";
//    }
}
