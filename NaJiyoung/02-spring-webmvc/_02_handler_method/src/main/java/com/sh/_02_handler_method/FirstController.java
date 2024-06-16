package com.sh._02_handler_method;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
 * - WebRequest : 스프링버젼의 HttpServletRequest
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
@RequestMapping("/first")
@Slf4j
@SessionAttributes({"id"})
public class FirstController {
    @GetMapping("/regist")
//    public String regist(){
//        return "first/regist"; // viewName : src/main/resources/templates/first/regist.html
//    }
    public void regist(){} // /first/regist path에서 viewName을 유추 : /first/regist.html

    /**
     * WebRequest
     * - 스프링버젼의 HttpServletRequest객체이다.
     * - HttpServletRequest API를 동일하게 사용가능하다.
     */
    @PostMapping("/regist")
    public String regist(Model model, WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        log.debug("name = {}", name);
        log.debug("price = {}", price);
        log.debug("categoryCode = {}", categoryCode);

        // view단 데이터 전달
        model.addAttribute("message", name + ", " + price + ", " + categoryCode + "가 정상적으로 전달되었습니다.");

        return "first/result";
    }

    @GetMapping("/modify")
    public void modify(Model model) {
        log.info("GET /first/modify 요청");
        // 기존데이터
        MenuDto menuDto = new MenuDto(1L, "인삼김밥", 30_000, 1, "Y");
        // view단에 데이터 전달
        model.addAttribute("menuDto", menuDto);
    }

    /**
     * @RequestParam
     * - 사용자 요청데이터의 name값과 일치하는 매개변수에 값을 자동으로 할당해준다.
     * - name값과 변수명이 다르다면, name값을 직접 명시할 수 있다.
     * - required=true(기본값)이므로, 해당 name속성을 찾을 수 없다면, 400오류가 난다.
     * - required=false로 변경하면, 해당 name값이 없어도 오류가 나지 않는다. null로 뜬다.
     *      - 이 때, defaultValue값이 지정되어 있다면, 해당값을 사용한다.
     */
    @PostMapping("/modify")
//    public String modify(@RequestParam(name = "name", required = false) String menuName, @RequestParam int price, Model model) {
    public String modify(@RequestParam(name = "name", required = false, defaultValue = "메뉴명 없음") String menuName, @RequestParam int price, Model model) {
        log.debug("name = {}", menuName);
        log.debug("price = {}", price);

        model.addAttribute("message", menuName + ", " + price + " 데이터로 수정했습니다...");
        return "first/result";
    }

    /**
     * name값을 key로, value값을 value로 하는 요소로 저장된 Map을 전달받을 수 있다.
     */
    @PostMapping("/modify2")
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
     * Command객체
     * - 사용자요청의 name값과 일치하는 객체의 필드에 값을 대입해준다.
     * @ModelAttribute
     * - 모델 속성에 대한 getter 어노테이션
     * - 커맨드 객체는 모델에 이미 등록되어 있다.
     * - 모델 속성명을 변경할 수도 있다. (기본값은 소문자로 시작하는 클래스명)
     *
     * @param model
     * @param menuDto
     * @return
     */
    @PostMapping("/search")
    public String search(@ModelAttribute("menu") MenuDto menuDto) {
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
        session.invalidate(); // 세션폐기
        return "first/loginResult";
    }

    /**
     * Model
     * - view단에 데이터를 전달하기 위한 목적 (모델 속성은 기본적으로 request scope를 가진다)
     * - 만약 session scope에 속성값을 저장하려면, 클래스레벨에 @SessionAttributes에 먼저 속성명을 등록해야 한다.
     * @param model
     * @param id
     * @param pwd
     * @return
     */
    @PostMapping("/login2")
    public String login(Model model, @RequestParam String id, @RequestParam String pwd) {
        log.debug("id/pwd = {}/{}", id, pwd);
        // 클래스레벨 @SessionAttributes("id") 등록이 되어 있으므로, 아래는 session scope로 관리된다.
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    /**
     * @SessionAttributes로 등록된 session속성을 폐기할 때는 HttpSession#invalidate()를 사용할 수 없다.
     * SessionStatus객체(@SessionAttributes로 등록된 속성을 관리하는 객체)의 setComplete()를 호출해 만료시킬 수 있다.
     * - 속성을 개별적으로 삭제시킬 수 없다.
     *
     * @return
     */
    @GetMapping("/logout2")
    public String logout2() {
        return "first/loginResult";
    }

    @GetMapping("/requestBody")
    public void requestBody() {}

    /**
     * @RequestBody
     * - http요청메세지의 본문영역을 그대로 읽어와서 전달
     * - queryString 또는 json데이터를 parsing해서 command객체에 담아서 전달할 수도 있다.
     * - 일반 form전송보다는 rest api방식에서 주로 사용한다.
     *
     * @param queryString
     */
    @PostMapping("/requestBody")
    public void requestBody2(@RequestBody String queryString) {
        log.debug("queryString = {}", queryString); // name=%EC%9D%B8%EC%82%BC%EA%B9%80%EB%B0%A5&price=2000&categoryCode=1&orderableStatus=Y
    }

    @GetMapping("/etc")
    public String etc(@RequestHeader("user-agent") String userAgent, @CookieValue("JSESSIONID") String jSessionId) {
        log.info("userAgent = {}", userAgent);
        log.info("JSESSIONID = {}", jSessionId);
        return "redirect:/"; // 302 Location=/app/
    }
}
