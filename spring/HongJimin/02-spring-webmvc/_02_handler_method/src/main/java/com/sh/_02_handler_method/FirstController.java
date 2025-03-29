package com.sh._02_handler_method;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.awt.*;
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
 *
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
@RequestMapping("/first")
@Slf4j
@SessionAttributes({"id"})
//@SessionAttributes({"id", "foo"}) // 여러개도 됨
public class FirstController {
    @GetMapping("/regist")
//    public String regist() {
//        return "first/regist"; // viewName : src/main/resources/static/index.html
//    }

    public void regist() { // veiwName을 반환하지 않아도 first/regist path에서 viewName을 유추함!
    }


    /**
     * ## WebRequest
     * - 스프링 버전의 HttpServletRequest 객체
     * - HttpServletRequest API를 동일하게 사용 가능하다.
     */
    @PostMapping("/regist")
    public String regist(Model model, WebRequest request) { // 포스트 요청은 db에 저장까지 해주세요! 하는 요청일 것
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        log.debug("name = {}", name);
        log.debug("price = {}", price);
        log.debug("categoryCode = {}", categoryCode);

        //view단에 데이터 전달
        model.addAttribute("message", name + ", " + price + ", " + categoryCode + "가 정상적으로 전달되었습니다.");

        return "first/result";
    }

    @GetMapping("/modify")
    public void modify(Model model) { // 수정 폼이라고 하면 기존 내용을 한 번 보여줌!
        log.info("GET /first/modify 요청");
        //기존 데이터
        MenuDto menuDto = new MenuDto(1L, "인삼김밥", 30_000, 1, "y");

        //view 단에 데이터 전달
        model.addAttribute("menuDto", menuDto);
    }

    /**
     * ✨@RequestParam - 사용자 요청 데이터의 name값과 일치하는 매개변수에 값을 자동으로 할당해줌
     * - name 갑과 변수 명이 다르다면, name값을 직접 명시할 수 있다.
     * - required=true(기본값)이므로, 해당 name 속성을 찾을 수 없다면 400오류가 난다.
     * - required=false로 변경하면, 해당 name 값이 없어도 오류가 나지 않는다.
     * - 이때, defaultValue값이 지정되어 있다면, 해당 값을 사용한다.
     * - 파라미터 순서는 전혀 상관 없움
     */
    @PostMapping("/modify")
    public String modify(@RequestParam(name = "name", required = false, defaultValue = "메뉴명 없음") String menuName, @RequestParam int price, Model model) { // Getparameter 안해도 됨
        log.debug("name = {}", menuName);
        log.debug("price = {}", price);

        model.addAttribute("message", menuName + ", " + price + " 데이터로 수정했습니다.");
        return "first/result";
    }

    /**
     * ✨Map으로 값 받는 방법
     * name값을 key로, value값을 value로 하는 요소로 저장된 Map을 전달받을 수 있다.
     */
    @PostMapping("modify2")
    public String modify2(Model model, @RequestParam Map<String, String> params) {
        log.info("POST / first/modify2");
        log.debug("params = {}", params);
        String name = params.get("name");
        int price = Integer.parseInt(params.get("price"));

        model.addAttribute("message", name + ", " + price + " 데이터로 수정했습니다.");
        return "first/result";
    }

    @GetMapping("/search")
    public void searh() {

    }

    /**
     * ### @ModelAttribute
     * - 모델 속성에 대한 getter 어노테이션
     * - 커맨드 객체는 모델에 이미 등록되어있다.
     * - 모델 속성명을 변경할 수도 있다.(기본값은 소문자로 시작하는 클래스명)
     */
    @PostMapping("/search")
    public String searh(Model model, @ModelAttribute("menu") MenuDto menuDto) { // menu로 지정한 것
        log.debug("menuDto = {}", menuDto);
        return "first/searchResult";
    }

    @GetMapping("/login")
    public void login() {

    }

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
     * ## Model
     * - view단에 데이터를 전달하기 위한 목적(모델 속성은 기본적으로 request scope를 가진다)
     * - 만약 session scope에 속성값을 저장하려면, 클래스 레벨에 `@SessionAttributes` 에 먼저 속성명을 등록해야 한다.
     */
    @PostMapping("/login2")
    public String login2(Model model, @RequestParam String id, @RequestParam String pwd) { // ✨Spring에서 데이터를 받아올 때 쓰는 게 Model
        log.debug("id/pwd = {}/{}", id, pwd);
        //클래스 레벨 @SessionAttributes("id") 등록이 되어 있으므로, 아래는 session scope로 관리된다.
        return "first/loginResult";
    }

    /**
     * ## @SessionAttributes 특징
     * - @SessionAttributes 로 등록된 session속성을 폐기할 때는 HttpSession#invalidate()를 사용할 수 없다.
     * - SessionStatus 객체(SessionAttributes로 등록된 속성을 관리하는 객체가 따로 있움)의 setComplete()를 호출해 만료시킬 수 있다.
     * - 속성을 개별적으로 삭제시킬 수 없다.
     */
    @GetMapping("/logout2")
    public String logout2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("/requestBody")
    public void requestBody() {

    }

    /**
     * ## @RequestBody
     * - http 요청 메세지의 본문 영역을 그대로 읽어와서 전달
     * - queryString 또는 json 데이터를 parsing해서 command 객체에 담아서 전달할 수도 있다.
     * - 일반 form 전송 보다는 rest api 방식에서 주로 사용한다.
     */
    @PostMapping("/requestBody")
    public void requestBody2(@RequestBody String queryString) {
        log.debug("queryString = {}", queryString);
    }

    @GetMapping("/etc")
    public String etc(@RequestHeader("user-agent") String userAgent, @CookieValue("JSESSIONID") String jsessionId) {
        log.info("userAgent = {}", userAgent);
        log.info("JSESSIONID = {}", jsessionId);
        return "redirect:/"; // 302 Location=/app/
    }
}
