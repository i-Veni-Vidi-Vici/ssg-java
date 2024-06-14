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
 *  - 사용자의 요청을 핸들링하는 클래스
 *  - @Component의 후손 어노테이션으로 자동으로 빈으로 등록
 */
@Controller
@Slf4j
public class MenuController {

    /**
     * url지정
     * method지정 : method를 지정하지 않는다면, 모든 전송방식을 다 처리한다.
     * contentType지정
     * @param model
     * @return
     */

    @RequestMapping("/menu/regist")
    public String registMenu(Model model){
        log.info("/menu/regist 요청!");

        // Model : view단에 data를 전달하기 위한 객체
        model.addAttribute("message", "메뉴를 신규등록합니다.");

        return "mappingResult"; // src/main/resources/templates/mappingResult.html을 찾아 응답을 작성한다.
    }

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

//    @RequestMapping(path = "/menu/modify", method = RequestMethod.GET)
    @GetMapping("/menu/modify") // 위의 코드와 같음. 간결한 식으로 사용됨.
    public String modifyMenu(Model model){
        log.info("GET /menu/modify 요청!");
        model.addAttribute("message", "메뉴 수정폼을 요청(GET)합니다.");
        return "mappingResult";
    }

//    @RequestMapping(path = "/menu/modify", method = RequestMethod.POST)
    @PostMapping("/menu/modify") // 위의 코드와 같음. 간결한 식으로 사용됨.
    public String modifyMenu2(Model model){
        log.info("POST /menu/modify 요청!");
        model.addAttribute("message", "메뉴 수정폼을 요청(POST)합니다.");
        return "mappingResult";
    }
}
