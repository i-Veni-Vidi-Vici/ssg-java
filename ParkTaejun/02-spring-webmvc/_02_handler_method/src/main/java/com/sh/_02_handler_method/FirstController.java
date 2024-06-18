package com.sh._02_handler_method;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.valves.rewrite.Substitution;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @Controller 클래스의 handler메소드가 가질수 있는 매개변수 타입
 *
 * <pre>
 * Servlet/JSP 스펙
 * - HttpServletRequest
 * - HttpServletResponse
 * - HttpSession
 * - InputStream/Reader : 요청에 대한 입력스트림
 * - OutputStream/Writer : 응답에 대한 출력스트림. ServletOutputStream, PrintWriter
 *
 * 사용자입력값처리
 * - WebRequest : 스프링버전의 HttpServletRequest
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
    // GET 방식 pOST 방식 어떻게 구별하는지
    @GetMapping("/regist")
    public String regist(){ // first/ regist pathe에서 view name을 유추할 것임.
        return "first/regist"; // viewName : src/main/resources/templates/first/regist.


        }

    /**
     * WebRequest
     * - 스프링버전의 HttpServletRequest 객체이다
     * - HttpServletRequest API를 동일하게 사용가능하다.
     * @param model
     * @param request
     * @return
     */
    @PostMapping("/regist")
    public String regist(Model model, WebRequest request){ // WebRequest 이용하면 survlet jsp 그대로 이용할 수 있다.
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        log.debug("name = {} ", name ); // 값이 잘 넘어왔는지 확인하는 용도, 디버그로 개발할떄는 필요 없ㅅ기 떄문에ㅔ?
        log.debug("price = {} ", price ); // 값이 잘 넘어왔는지 확인하는 용도, 디버그로 개발할떄는 필요 없ㅅ기 떄문에ㅔ?
        log.debug("categoryCode = {} ", categoryCode ); // 값이 잘 넘어왔는지 확인하는 용도, 디버그로 개발할떄는 필요 없ㅅ기 떄문에ㅔ?

        // view 단 데이터 전달
        model.addAttribute("message", name + ", " + price + ", " + categoryCode + "가 정상적으로 전달 되었습니다");
        return "first/result";
    }

    @GetMapping("/modify") // 보통 수정이라고 하면 기존의 내용이 뭐였는지 한번 보여주고 그걸 수정하게 해야한다
    public void modify(Model model ){

        log.info("GET/first/modify 요청");
            // 기존 데이터 // 메뉴 번호, 메뉴이름 , 가격 , 식사
        MenuDto menuDto = new MenuDto(1L, "인삼김밥", 30_000,1 , "y");
            // view 단에 데이터 전달
        model.addAttribute("menuDto", menuDto);

    }


    /**
     * RequestParam
     *  사용자 요청데이터의 name값과 일치하는 매개변수에 값을 자동으로 ㅎㄹ당해준다
     *  name값과 변수명ㅇ이 다르다면,
     */

    @PostMapping("/modify") // name이 name 값인 , 그리고 프라이스가 프라이스인 값을 넣어주겠다
    public String modify(@RequestParam(name = "name", required = false, defaultValue = "메뉴명 없음") String name, @RequestParam int price, Model model){
        log.debug("name = {}", name);
        log.debug("price = {}", price);

        model.addAttribute("message", name + " , " + price +  ". . .  데이터로 수정 했습니다 ");


        return "first/result";
    }

    /**
     * name 값을 key로, value값을 value로 하는 요소로 저장된 Map을 전달 받을 수 있다.
     *
     * @param model
     * @param params
     * @return
     */
    @PostMapping("/modify2")
    public String modify2(Model model, @RequestParam Map<String, String> params){
        log.info("POST/ first/ modify2 요청");
        log.debug("params = {}", params);
        String name =params.get("name");
        int price =Integer.parseInt( params.get("price"));

        model.addAttribute("message", name + " , " + price +  ". . .  데이터로 수정 했습니다 ");


        return "first/result";
    }

    /**
     * Command 객체
     * - 사용자 요청으; name값과 일치하는 객체의 필드에 값을 대입해준다.
     * @ModelAttribute
     * = 모델 속성에 대한 getter 어노테이션임.
     * - 커맨드객체는 모델에 이미 등록되어 있다.
     * - 모델 속성명을 변경할 수도 있다 (기본값은 소문자로 시작하는 클래스명)
     *
     */
    @GetMapping("/search")
    public void search(){}

    // 가장 스프링 다운? @ModelAttribute
    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("menu") MenuDto menuDto){
        log.debug("menuDto = {}" , menuDto);
        return "first/searchResult";
    }

    @GetMapping("/login")
    public void login(){}

//    @PostMapping("/login")
//    public String login(HttpSession session, @RequestParam String id, @RequestParam String pwd){
//        log.debug("id/pwd = {}/{}", id, pwd);
//        session.setAttribute("id", id);
//        return "first/loginResult";
//    }
// http 받아옴
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 세션폐기
        return "first/loginResult";


    }

    /**
     *Model
     * - view단에 데이터를 전달하기 위한 목적(모델 속성은 기본적으로 request scope 가진다)
     * - 클래스레벨에 sessionAttributes 어노테이션 등록해주고 값적어주면 ~ 몰라
     *
     * - 만약 session scope에 속성값을 저장하려면, 클래스레벨에 @SessionAttributes에 먼적 속서염 등록해야한다.
     *
     * @param model
     * @param id
     * @param pwd
     * @return
     */
// http 안받아옴 model 그 두개 차이 알아보기
    @PostMapping("/login2")
    public String login(Model model, @RequestParam String id, @RequestParam String pwd){
        log.debug("id/pwd = {}/{}", id, pwd);
        // 클래스레벨에 @SessionAttributes ("id") 등록이 되어 있으므로, 아래는 session scope에 의해 관리된다ㅏ.
        model.addAttribute("id", id);
        return "first/loginResult";
    }

    /**
     * @SessionAttributes로 등록된 session속성을 폐기할떄는 HttpSesion#invalidate()를 사용할 수 없다.
     * SessionStatus 객체(@SessionAttributes로 등록딘 속성을 관리하는 객체)의 setComplete()를 호출 해 만료시킬 수 있다.
     * - 속성을 개별적으로 삭제시킬 순 없다!!!
     *
     */

    @GetMapping("/logout2")
    public String logout2(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    @GetMapping("/requestBody")
    public void requestBody(){

    }

    /**
     * @RequestBody
     * - http 요청메세지의 본문영역을 그대로 읽어와서 전달
     * - quryString 또는 join데이터를 parsing해서 command객체에 담아서 전달할 수도 있다
     * - 일반 form 전송보다는 rest api 방식에서 주로 사용한다
     * @param queryString
     */

    @PostMapping("/requestBody")
    public void requestBody2(@RequestBody String queryString){
        log.debug("queryString = {}", queryString);

    }

    @GetMapping("/etc")
    public String etc(@RequestHeader("user-agent")String userAgent, @CookieValue("JSESSIONID") String jSessionId){
        log.info("userAgent = {}", userAgent);
        log.info("JSESSIONID = {}", jSessionId);
        return "redirect:/"; // 302 Location=app/
    }

}

