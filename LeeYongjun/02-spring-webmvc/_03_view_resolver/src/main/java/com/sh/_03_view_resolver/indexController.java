package com.sh._03_view_resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class indexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    /**
     * ViewResolver빈
     * - controller에서 반환받은 viewName을 가지고 view단을 선정하는 작업을 한다.
     * - tyhmeleaf를 사용시에는 ThyleafViewResolver빈을 사용한다,
     * - prefix를 "resources/templates/", suffix를 ".html"로 추가하여 viewName을 완성한다.
     *  =
     */
    @GetMapping("/string-forward")
    public String stringForward(Model model){
        model.addAttribute("message","😂😂");
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect(Model model){
        log.info("GET /string-redirect");
        return "redirect:http://naver.com";
    }

    @GetMapping("/string-redirect-flash")
    public String stringRedirectFlash(RedirectAttributes redirectAttributes){
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage","😂😂😂");
        return "redirect:/";
    }

    /**
     * ModelAndView
     * - Model과 View를 합친 객체
     * - ModelAndView를 사용하다가, Model과 ViewName:String으로 분리해서 사용하게 되었다.
     */
    @GetMapping("/mav-forward")
    public ModelAndView mavForward(ModelAndView mav){
        // 모델에 속성추가
        mav.addObject("message","😂😂");
        // view 지정
        mav.setViewName("result");
        return mav;
    }

    @GetMapping("/mav-redirect")
    public ModelAndView mavRedirect(ModelAndView mav){
        // view 지정
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-flash")
    public ModelAndView mavRedirectFlash(ModelAndView mav,RedirectAttributes redirectAttributes){
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage","😂1😂2😂");
        mav.setViewName("redirect:/");
        return mav;
    }

    @GetMapping("/mav-redirect-param")
    public ModelAndView mavRedirectParam(ModelAndView mav, RedirectAttributes redirectAttributes){
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage","😂1😂😂3");
        mav.setViewName("redirect:/");
        return mav;
    }
}
