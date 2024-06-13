package com.sh._01_request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Controller
 * - 사용자의 요청을 핸들링하는 클래스
 * - @Component의 후손 어노테이션으로 자동으로 빈으로 등록
 */
@Controller
@Slf4j
public class MenuController {
    /**
     * url
     * contentType 지정
     * @param model
     * @return
     */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        log.info("/menu/regist 요청!");

        // Model view단에 data를 전달하기 위한 객체

        model.addAttribute("message", "메뉴를 신규등록합니다...");

        return "mappingResult"; //src/main/resources/templates/mappingResult.html을 찾아 응답
    }
//    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    @GetMapping("/menu/modify")
    public String modifyMenu(Model model) {
        log.info("GET /menu/modify 요청!");
        model.addAttribute("message", "메뉴 수정폼을 요청합니다...");
        return "mappingResult";
    }

//    @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
    @PostMapping("/menu/modify")
    public String modifyMenu2(Model model) {
        log.info("GET /menu/modify 요청!");
        model.addAttribute("message", "메뉴 수정을 요청(POST)합니다...");
        return "mappingResult";
    }
}
