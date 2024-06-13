package com.sh._01_request_mapping;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * <pre>
 * 요청 메소드 전용 어노테이션 (since 4.3)
 * 요청 메소드          어노테이션
 * POST         	@PostMapping
 * GET          	@GetMapping
 * PUT          	@PutMapping
 * DELETE       	@DeleteMapping
 * PATCH			@PatchMapping
 * 이 어노테이션들은 @RequestMapping 어노테이션에 method 속성을 사용하여 요청 방법을 지정하는 것과 같다.
 * 각 어노테이션은 해당하는 요청 메소드에 대해서만 처리할 수 있도록 제한하는 역할을 한다.
 * <pre>
 */

/**
 * @Controller
 * 사용자의 요청을 핸들링 하는 클래스.
 * @Component의 후손 어노테이션으로 자동으로 빈으로 등록 됨.
 */
@Controller
@Slf4j
public class MenuController {
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        log.info("/menu/regist 요청!");

        //Model View 단에 data를 전달
        model.addAttribute("message", "menu를 신규 등롭합니다");
        return "mappingResult"; // sec /main/resources/templates/mappingResult.html을 찾아 응답
    }

    @RequestMapping(path = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        log.info("GET/ menu/modify 요청!!");
        model.addAttribute("message", "get 메뉴 수정을 요청합니다...");

        return "mappingResult";
    }

    @RequestMapping(path = "/menu/modify", method = RequestMethod.POST)
    public String modifyMenu2(Model model) {
        log.info("POST / menu/modify 요청!!");
        model.addAttribute("message", "POST 메뉴 수정을 요청합니다...");

        return "mappingResult";
    }

    /**
     * 하나의 ~ 에서 여러개의 url을 처리할 수 있다.
     *
     * @param model
     * @return
     */

}
