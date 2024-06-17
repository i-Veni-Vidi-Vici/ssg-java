package com.sh._03_view_resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class IndexController {
    /**
     * ViewResolver 빈
     * - controller 에서 반환 받은 viewName 을 가지고 view 단을 선정하는 작업을 한다.
     * - thymeleaf 를 사용시에는 ThymeleafViewResolver 빈을 사용한다.
     * - prefix 를 "resource/templates", suffix 를 ".html" 로 추가하여 viewName 을 완성한다.
     */
    @GetMapping("/string-forward")
    public String forward(Model model) {
        model.addAttribute("message", "HEHEHE");
        return "result";
    }

    @GetMapping("/string-redirect")
    public String redirect() {
        // 302 응답 Location=/app/
        return "redirect:http://naver.com";
    }

    @GetMapping("/string-redirect-flash")
    public String stringRedirectFlash(RedirectAttributes redirectAttributes) {
        log.info("GET /string-redirect-flash");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage", "flashMessage");
        return "redirect:/";
    }

    @GetMapping("/string-redirect-param")
    public String stringRedirectParam(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("paramMessage", "paramMessage");
        return "redirect:/"; // /app/?paramMessage=paramMessage
    }

    /**
     * ModelAndView
     * - Model 과 View 를 합친 객체
     * - ModelAndView 를 사용하다가, Model 과 ViewName:String 으로 분리해서 사용하게 되었다.
     */
    @GetMapping("/mav-forward")
    public ModelAndView mavForward(ModelAndView mav) {
        // 모델에 속성 추가
        mav.addObject("message", "HEHEHE");
        // view 지정
        mav.setViewName("result");
        return mav;
    }

    @GetMapping("/mav-redirect")
    public ModelAndView mavRedirect(ModelAndView mav) {
        // 모델에 속성 추가
        mav.addObject("message", "HEHEHE");
        // view 지정
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-flash")
    public ModelAndView mavRedirectFlash(ModelAndView mav, RedirectAttributes redirectAttributes) {
        log.info("GET /mav-redirect-flash");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage", "flashMessage");
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-param")
    public ModelAndView mavRedirectParam(ModelAndView mav, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("paramMessage", "paramMessage");
        mav.setViewName("redirect:/");
        return mav;
    }
}
