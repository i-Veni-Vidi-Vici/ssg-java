package com.sh._03_view_resolver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class IndexController {
    //8개 했는데
    // 위에 4개는 Model+viewName:String
    // 아래 4개는 ModelAndView


    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * ViewResolver빈, Resolver = 뭔가를 처리하는 느낌이다
     * - Controller에서 반환받은 viewName을 가지고 view단을 선정하는 작업을 한다.
     * - thymeleaf를 사용시에는 thymeleafResolver빈을 사용한다.
     * - prefix를 "resources/templates/". suffix를 ".html"로 추가하여 viewName을 완성한다
     * @return
     */
    @GetMapping("/string-forward")
    public String stringForward() {
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect(Model model) {
        log.info("GET /string-redirect");
        return "redirect:http://naver.com";
    }

    // addFlashAttributes와 addAttributes
    // addflash는 서버단의 session에 저장된다 = 실행 후 session에 있네?? 그럼 실행 그리고 동시에 flash메시지 삭제
    // addAttributes가 app/?paramMsg=수박수박수박 이렇게 간다, html-script 에서 url을 파싱해서 어?? param이 있는데?? 출력 -> 새로고침 -> 어?? param이 있네?? 출력

    // servlet에서 서로다른 리다이렉트가 주고 받을 데이터를 세션을 통해 하듯이 하는 방법이다
    @GetMapping("/string-redirect-flash")
    public String stringRedirectFlash(RedirectAttributes redirectAttributes) {
        log.info("info > GET /string-redirect-flash");
        redirectAttributes.addAttribute("flashMessage","이건 플래쉬방법");
        return "redirect:/";
    }

    @GetMapping("/string-redirect-param")
    public String stringRedirectParam(RedirectAttributes redirectAttributes)
    {
        log.info("info > GET /string-redirect-param");
        redirectAttributes.addAttribute("paramMessage","수박수박수박");
        return "redirect:/"; // 리다이렉트 할 때 /app/?paramMessage=수박수박수박
    }


    /**
     * ModelAndView
     * - Model과 view를 합친 객체
     * - ModelAndView를 사용하다가, Model과 viewName:String으로 분리해서 사용하게 되었다
     * @return
     */
    @GetMapping("/mav-forward")
    public ModelAndView mavForward(ModelAndView mav) {
        // 모델에 속성추가
        mav.addObject("message","🚗🚗🚗🚗🚗🚗");

        // view지정
        mav.setViewName("result");

        return mav;
    }

    @GetMapping("/mav-redirect")
    public ModelAndView mavRedirect(ModelAndView mav) {
        // view지정
        mav.setViewName("redirect");

        return mav;
    }

    // ModelAndView 이것과 RedirectAttributes 이거는 다른거다
    @GetMapping("/mav-redirect-flash")
    public ModelAndView mavRedirectFlash(ModelAndView mav, RedirectAttributes redirectAttributes) {
        // view지정
        redirectAttributes.addFlashAttribute("flashMessage","리다이렉트 플래쉬");
        mav.setViewName("redirect:/");

        return mav;
    }

    @GetMapping("/mav-redirect-param")
    public ModelAndView mavRedirectParam(ModelAndView mav,RedirectAttributes redirectAttributes) {
        // view지정
        redirectAttributes.addFlashAttribute("paramMessage","리다이렉트 파람");
        mav.setViewName("redirect:/");

        return mav;
    }

}
