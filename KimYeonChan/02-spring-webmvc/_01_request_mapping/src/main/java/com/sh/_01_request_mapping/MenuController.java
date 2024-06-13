package com.sh._01_request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;

/**
 * .@Controller
 * - 사용자의 요청을 핸들링하는 클래스
 * - @Component 의 후손 어노테이션으로 자동으로 빈으로 등록
 */
@Controller
@Slf4j
public class MenuController {
    /**
     * url 지정
     * method 전송 방식을 저장하지 않으면 모든 전송 방식에 대응한다.
     * contentType 지정
     */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        log.info("/menu/regist 요청!");

        // Model view 단에 data 를 전달하기 위한 객체
        model.addAttribute("message", "메뉴를 신규등록합니다...");

        return "MappingResult";
    }

    /**
     * <pre>
     * 요청 메소드 전용 어노테이션 (since 4.3)
     * 요청 메소드         어노테이션
     * POST             @PostMapping
     * GET          	@GetMapping
     * PUT          	@PutMapping
     * DELETE       	@DeleteMapping
     * PATCH			@PatchMapping
     * 이 어노테이션들은 @RequestMapping 어노테이션에 method 속성을 사용하여 요청 방법을 지정하는 것과 같다.
     * 각 어노테이션은 해당하는 요청 메소드에 대해서만 처리할 수 있도록 제한하는 역할을 한다.
     * <pre>
     */
//    @RequestMapping(path = "/menu/modify", method = RequestMethod.GET)
    @GetMapping("/menu/modify")
    public String modifyMenu(Model model) {
        log.info("GET /menu/modify 요청!");

        model.addAttribute("message", "메뉴 수정폼 요청(GET)합니다...");

        return "MappingResult";
    }

//    @RequestMapping(path = "/menu/modify", method = RequestMethod.POST)
    @PostMapping("/menu/modify")
    public String modifyMenu2(Model model) {
        log.info("POST /menu/modify 요청!");

        model.addAttribute("message", "메뉴 수정을 요청(POST)합니다...");

        return "MappingResult";
    }
}
