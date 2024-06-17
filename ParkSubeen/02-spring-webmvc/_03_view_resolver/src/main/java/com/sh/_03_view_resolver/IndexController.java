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
     * ViewResolver빈
     * - controller에서 반환받은 viewName을 가지고 view단을 선정하는 작업을 한다.
     * - thymeleaf를 사용시에는 ThymeleafViewResolver빈을 사용한다.
     * - prefix를 "resources/templates/", suffix를 ".html"로 추가하여 viewName을 완성한다.
     * @return
     */
    @GetMapping("/string-forward")
    public String stringForward(Model model) {
        model.addAttribute("message", "🍖🍖🍖");
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect(Model model) {
        log.info("GET /string-redirect");
        // 302응답 Location=/app/
//        return "redirect:/"; // /app 뒤에 붙을 path를 작성, Location=http://localhost:8080/app/
        return "redirect:http://naver.com"; // http부터 작성할 수 있다.
    }

    @GetMapping("/string-redirect-flash")
    public String stringRedirectFlash(RedirectAttributes redirectAttributes) {
        log.info("GET /string-redirect-flash");
        // 이번 요청에 생성된 데이터 (일회용) - 해당 데이터는 session에 들어가지만 새로고침하면 사라져있어서 일회용
        redirectAttributes.addFlashAttribute("flashMessage", "🥨🥨🥨");
        return "redirect:/";
    }

    @GetMapping("/string-redirect-param")
    public String stringRedirectParam(RedirectAttributes redirectAttributes) {
        log.info("GET /string-redirect-flash");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addAttribute("paramMessage", "🍒🍒🍒");
        return "redirect:/"; // /app/?paramMessage=🍒🍒🍒
    }

    /**
     * ModelAndView
     * - Model과 View를 합친 객체
     * - ModelAndView를 사용하다가, Model과 ViewName:String으로 분리해서 사용하게 되었다.
     */
    @GetMapping("/mav-forward")
    public ModelAndView mavForward(ModelAndView mav) {
        // 모델에 속성추가
        mav.addObject("message", "🥨🥨🥨");
        // view지정
        mav.setViewName("result");
        return mav;
    }

    @GetMapping("/mav-redirect")
    public ModelAndView mavRedirect(ModelAndView mav) {
        log.info("GET /mav-redirect");
        // view지정
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-flash")
    public ModelAndView mavRedirectFlash(ModelAndView mav, RedirectAttributes redirectAttributes) {
        log.info("GET /string-redirect-flash");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage", "🥨🥨🥨");
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-param")
    public ModelAndView mavRedirectParam(ModelAndView mav, RedirectAttributes redirectAttributes) {
        log.info("GET /string-redirect-flash");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addAttribute("paramMessage", "🍒🍒🍒");
        mav.setViewName("redirect:/");
        return mav; // /app/?paramMessage=🍒🍒🍒
    }
}
