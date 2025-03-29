package com.sh._02_handler_method;


import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first")
@Slf4j
@SessionAttributes({"id"})// sessionScope에 저장해줘, 관리를 해줄꼐
public class FirstController {

    @GetMapping("/regist") // 그냥 보여주세요
//    public String regist(){
//        return "first/regist"; // viewName : src/main/resources/templates/first/regist.html
//    }
    public void regist() {
    } // /first/regist path에서 viewName을 유추


    /**
     * WebRequest
     * - 스프링버전의 HttpServletRequest 객체이다
     * - HttpServletRequest API를 동이랗게 사용가능하다
     *
     *
     * @param model
     * @param request
     * @return
     */
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
     * - WebRequest : 스프링버전의 HttpServletRequest 객체이다
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

    @PostMapping("/regist") // DB가 바뀔 수 있는 성격이다
    public String regist(Model model, WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        log.debug("name = {}", name);
        log.debug("price = {}", price);
        log.debug("categoryCode = {}", categoryCode);


        // view단 데이터 전달
        model.addAttribute("message", name + "," + price + "," + categoryCode + "가 정상적으로 전달되었습니다");

        return "first/result";
    }

    @GetMapping("/modify") // first/modify.html로 넘어간다
    public void modify(Model model) {
        log.info("GET /first/modify");

        // 기존 데이터
        MenuDto menuDto = new MenuDto(1L, "인산", 30_000, 1, "Y");

        // view단에 데이터 전달
        model.addAttribute("menuDto", menuDto);
    }


    /**
     * @param menuName
     * @param price
     * @param model
     * @return
     * @RequestParam - 사용자 요청데이터의 name값과 일치하는 매개변수에 값을 자동으로 할당해준다.
     * - name갑소가 변수명이 다르다면, name값을 직접 명시할 수 있다
     * - required=true(기본값) 이므로, 해당 name속성을 찾을 수 없다면, 400오류가 난다
     * - required=false로 변경하면, 해당 name 값이 없어도 오류가 나지 않습니다
     * 이때
     */
    @PostMapping("/modify")
//    지금 @RequestParam() 괄호에 아무 것도 없다면 매개변수명과 같은 걸로 찾고, 그게 없다면 괄호안에 가져와야 하는 이름을 수동 입력한다
    // 그니깐 @RequestParam() 괄호안에 아무것도 없다 그럼 매개변수와 같은 name값을 찾는다 = 자동scan, 따로 입력을 했으면 Ex)price, price로 등록된 값을 찾아서 매개변수와 연결시켜 준다
    public String modify(
            @RequestParam(value = "name", required = false, defaultValue = "메뉴명이 없습니다") String menuName,
            @RequestParam int price, Model model) {
        log.debug("name = {}", menuName);
        log.debug("price = {}", price);

        model.addAttribute("message", menuName + "," + price + "데이터로 수정했습니다");
        return "first/result";
    }


    /**
     * name값을 key로 value값을 value로 하는 요소로 저장된 Map을 전달받을 수 있다.
     */
    // 개수가 많은 경우, map으로 받아온다
    @PostMapping("/modify2")
    public String modify2(Model model, @RequestParam Map<String, String> params) {

        log.info("POSY /first/modify2 요청!");
        log.info("params= {}", params);

        String name = params.get("name");
        int price = Integer.parseInt(params.get("price"));

        model.addAttribute("message", name + "," + price + "데이터로 수정했습니다");

        return "first/result";
    }

    @GetMapping("/search")
    public void search() {

    }

    /**
     * Command 객체
     * - 사용자 요청의 name값과 일치하는 객체의 필드에 값을 대입합니다
     *
     * @param model
     * @param menuDto
     * @ModelAttribute - 모델 속성에 대한 getter 어노테이션
     * - 커맨드 객체는 모델에 이미  등록되어 있다
     * - 모델 속성명을 변경할 수도 있다 (기본값은 소문자로 시작하는 클래스명)
     */
    @PostMapping("/search")
    public String search(Model model, @ModelAttribute MenuDto menuDto) {
        log.debug("menuDto = {}", menuDto);

        return "first/searchResult";
    }

    @GetMapping("/login")
    public void login() {

    }

    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String id, @RequestParam String pwd) {
        log.debug("id/paw = {}/{}", id, pwd);
        session.setAttribute("id", id);

        return "first/loginResult";
    }

    //HttpSession으로 받는 이유는 session.invalidate해야 하기 때문에
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "first/loginResult";
    }


    /**
     * Model
     * - view단에 데이터를 전달하기 위한 목적 (모델 속성은 기본적으로 request scope를 가진다)
     * - 만약 session scope에 속성값을 저장하려면, 클래스레벨에 @SessionAttributes에 먼저 속성명을 등록해야 한다.
     * 이번에도 쓰고 싶고, 다른 곳에서도 쓰고 싶고, session 범위에서도 쓰고 싶어!! 할 때 쓴다
     * @param model
     * @param id
     * @param pwd
     * @return
     */
    @PostMapping("/login2")
    public String login2(Model model, @RequestParam String id, @RequestParam String pwd) {
        log.debug("세션 스코프입니다 > id/paw = {}/{}", id, pwd);
        // 클래스레벨 @SessionAttributes("id")등록이 되어 있으므로, 아래는 session scope로 관리가 된다
        model.addAttribute("id",id);

        return "first/loginResult";
    }


    /**
     * @SessionAttributes로 등록된 session속성을 폐기할때는 HttpSession#invalidate() 사용 불가
     * SessionStatus객체(SessionAttributes로 등록된 속성을 관리하는 객체)의 setComplete()를 호출해 만료시킬 수 있다.
     * - 속성을 개별적으로 삭제 불가
     * @return
     */
    @GetMapping("/logout2")
    public String login2(SessionStatus sessionStatus) {
        log.debug("지금은 SessionStatus입니다");
        sessionStatus.setComplete(); // 이러면 session종료

        return "first/loginResult";
    }


    @GetMapping("/requestBody")
    public void requestbody() {

    }

    /**
     * @RequestBody
     * - http요청 메세지의 본문영역을 그대로 읽어와서 전달
     * - queryString 또는 json데이터를 parsing해서 command객체에 담아서 전달 할 수도 있다
     * - 일반 form 전송보다는 rest api방식에서 주로 사용한다
     * @param queryString
     */

    @PostMapping("/requestBody")
    public void requestBody2(@RequestBody String queryString) {
        log.debug("queryString = {}",queryString);

    }

    @GetMapping("/etc")
    public String etc(@RequestHeader("user-agent") String userAgent ,@CookieValue("JSESSIONID") String jsessionId) {
        log.info("userAgent= {}",userAgent);
        log.info("jsessionId= {}",jsessionId);
        return "redirect:/"; // 302 Location=/app/ 이런 의미이다
    }
}















