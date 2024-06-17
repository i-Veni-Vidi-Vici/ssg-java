package com.sh._02_handler_method;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * <pre>
 * @Controller 클래스의 handler메소드가 가질수 있는 매개변수 타입
 *
 * Servlet/JSP 스펙
 * - HttpServletRequest
 * - HttpServletResponse
 * - HttpSession
 * - InputStream/Reader : 요청에 대한 입력스트림
 * - OutputStream/Writer : 응답에 대한 출력스트림. ServletOutputStream, PrintWriter
 *
 * 사용자입력값처리
 * - WebRequest
 * - @RequestParam : 사용자입력값을 자바변수에 대입처리(필수여부 설정)
 * - Command객체 : http요청 파라미터를 커맨드객체에 저장한 DTO객체
 * - CommandMap :  HandlerMethodArgumentResolver에 의해 처리된 사용자입력값을 가진 Map객체
 * - @Valid : 커맨드객체 유효성 검사객체
 * Error, BindingResult : Command객체에 저장결과(Command객체 바로 다음위치시킬것.)
 * - @PathVariable : 요청url중 일부를 매개변수로 취할 수 있다.
 * - @RequestHeader : 헤더값
 * - @CookieValue : 쿠키값
 * - @RequestBody : http message body에 작성된 json을 vo객체로 변환처리
 *
 * 모델 관련
 * - ModelAndView
 * - ModelMap
 * - Model
 * - @ModelAttribute : model속성에 대한 getter
 * - @SessionAttribute : session속성에 대한 getter(required여부 선택가능)
 *  	- @SessionAttributes : session에서 관리될 속성명을 class-level에 작성후에 사용가능
 * - SessionStatus: @SessionAttributes로 등록된 속성에 대하여 사용완료(complete)처리. 세션을 폐기하지 않고 재사용한다.
 * - RedirectAttributes : DML처리후 요청주소 변경을 위한 redirect시 속성처리 지원
 *
 * 기타
 * - MultipartFile : 업로드파일 처리 인터페이스. CommonsMultipartFile
 * - java.util.Locale : 요청에 대한 Locale
 *
 * </pre>
 */
@Controller
@RequestMapping("/first/*")
@SessionAttributes({"id"})
@Slf4j
public class FirstController {
    @GetMapping("/regist")
//    public String regist() {
//        return "first/regist"; // viewName: src/main/resources/templates/first/regist.html
//    }
    public void regist() {} // /first/regist path 에서 viewName 을 유추

    /**
     * WebRequest
     * - spring 버전의 HttpServletRequest 객체이다.
     * - HttpServletRequest API 를 동일하게 사용가능하다.
     */
    @PostMapping("/regist")
    public String regist(Model model, WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        log.debug("name = {}, price = {}, categoryCode = {}", name, price, categoryCode);

        // view 단 데이터 전달
        model.addAttribute("message", name + ", " + price + ", " + categoryCode + "가 정상적으로 전달되었습니다.");

        return "first/result";
    }

    @GetMapping("/modify")
    public void modify(Model model) {
        // 기존 데이타
        MenuDto menuDto = new MenuDto(1L, "인삼김밥", 30_000, 1, "Y");
        // view 데이터 전달
        model.addAttribute("menuDto", menuDto);
    }

    /**
     * @RequestParam
     * - 사용자 요청 데이터의 name 값과 일치하는 매개변수에 값을 자동으로 할당해준다.
     * - name 값과 변수명이 다르다면, name 값을 직접 명시할 수 있다.
     * - required=true(기본값)이므로, 해당 name 속성을 찾을 수 없다면, 400 오류가 난다.
     * - required=false 로 변경하면, 해당 name 값이 없어도 오류가 나지 않는다.
     *   - 이때, defaultValue 값이 지정되어 있다면 해당 값을 사용한다.
     */
    @PostMapping("modify")
    public String modify(
            Model model,
            @RequestParam(name = "name", required = false, defaultValue = "default") String menuName,
            @RequestParam int price
    ) {
        log.debug("name = {}", menuName);
        log.debug("price = {}", price);

        model.addAttribute("message", menuName + ", " + price + " 데이터로 수정했습니다...");

        return "first/result";
    }

    /**
     * name 값을 key 로, value 값을 value 로 하는 요소로 저장된 Map 을 전달 받을 수 있다.
     */
    @PostMapping("modify2")
    public String modify2(Model model, @RequestParam Map<String, String> params) {
        log.info("POST /first/modify2 요청!");
        log.debug("params = {}", params);

        String name = params.get("name");
        int price = Integer.parseInt(params.get("price"));
        model.addAttribute("message", name + ", " + price + " 데이터로 수정했습니다...");

        return "first/result";
    }

    @GetMapping("/search")
    public void search() {}

    /**
     * Command 객체 (Command Pattern)
     * - 사용자 요청의 name 값과 일치하는 객체의 필드에 값을 대입한다.
     * @ModelAttribute
     * - 모델 속성에 대한 getter 어노테이션
     * - 커맨드 객체는 모델에 이미 등록되어 있다.
     * - 모델 속성명을 변경할 수 있다. (기본값은 소문자로 시작하는 class 명)
     *
     */
    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("menu") MenuDto menuDto) {
        log.debug("menuDto = {}", menuDto);
        return "first/searchResult";
    }

    @GetMapping("/login")
    public void login() {}
    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String id, @RequestParam String pwd) {
        log.debug("id/pwd = {}/{}", id, pwd);
        session.setAttribute("id", id);
        return "first/loginResult";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 폐기
        return "first/loginResult";
    }

    /**
     * Model
     * - view 단에 데이터를 전달하기 위한 목적(모델 속성은 기본적으로 request scope 를 가진다.)
     * - 만약 session scope 에 속성값을 저장하려면, 클래스레벨에 @SessionAttributes 에 먼저 속성명을 등록
     */
    @PostMapping("/login2")
    public String login2(Model model, @RequestParam String id, @RequestParam String pwd) {
        log.debug("id/pwd = {}/{}", id, pwd);
        // 클래스레벨 @SessionAttributes("id") 등록이 되어 있으므로, 아래는 session scope 에서 관리된다.
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    /**
     * @SessionAttributes 로 등록된 session 속성을 폐기할때는 HttpSession#invalidate()를 사용할 수 없다.
     * SessionStatus 객체(@SessionAttributes 로 등록된 속성을 관리하는 객체)의 setComplete()를 호출해 만료시킬 수 있다.
     * - 속성을 개별적으로 삭제시킬 수 없다.
     */
    @GetMapping("/logout2")
    public String logout2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("/requestBody")
    public void requestBody() {}

    /**
     * @RequestBody
     * - http 요청메세지의 본문영역을 그대로 읽어와서 전달
     * - queryString 또는 json 데이터를 parsing 해서 command 객체에 담아서 전달할 수도 있다.
     * - 일반 form 전송보다는 rest api 방식에서 주로 사용한다.
     */
    @PostMapping("/requestBody")
    public void requestBody(@RequestBody String queryString) {
        log.debug("queryString = {}", queryString); // queryString = name=%EA%B9%80%EC%97%B0%EC%B0%AC&price=1000&categoryCode=1&orderableStatus=Y
    }

    @GetMapping("/etc")
    public String etc(@RequestHeader("user-agent") String userAgent, @CookieValue("JSESSIONID") String jSessionId) {
        log.info("userAgent = {}", userAgent); // userAgent = Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36
        log.info("jSessionId = {}", jSessionId); // jSessionId = 4067A2054E92823AE07E59F2EA9EFC44
        return "redirect:/"; // 302 Location=/app/
    }
}