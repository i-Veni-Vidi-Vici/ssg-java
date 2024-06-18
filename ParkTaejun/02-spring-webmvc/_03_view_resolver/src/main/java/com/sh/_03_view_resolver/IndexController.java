package com.sh._03_view_resolver;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class IndexController {
    @GetMapping("/")
    public String index(){
        log.info("GET / ");
        return "index";
    }
    /**
     * ViewResolver빈
     * - controller에서 반환받은 viewName을 가지고 view단을 선정하는 작업을 한다.
     * - 타임리프를 쓰고 있을 때는 ThymeleafViewResolver빈을 사용한다.
     * -prefix를 resource/templates, suffix를 html로 추가하여 viewName을 완성한다
     * @return
     */
    @GetMapping("/string-forward")
    public String stringForwad(Model model){
        model.addAttribute("message", "🍖🍖🍖");
        return "result";
    }

    @GetMapping("/string-redirect")
    public String stringRedirect(Model model){
        log.info("GET /string-redirect");
        // 302응답 Location=/app/
//        return "redirect:/";
        return "redirect:http://naver.com";
    }

    @GetMapping("/string-redirect-flash")
    public String stringRedirectFlash(RedirectAttributes redirectAttributes){
        // 이번 요청에 생성된 데이터
        redirectAttributes.addFlashAttribute("flashMessage", "🍟🍟🍟");
        return "redirect:/";
    }

    @GetMapping("/string-redirect-param")
    public String stringRedirectParam(RedirectAttributes redirectAttributes){
        log.info("GET /string-redirect-falsh");
        // 이번 요청에 생성된 데이터
        redirectAttributes.addAttribute("paramMessage", "🍉🍉🍉");
        return "redirect:/"; // /app/?paramMessage = 🍉🍉🍉
    }

    /**
     * ModelAndView
     * - Model과 View를 합친 객체
     * - ModelAndVIew를 사용하다가, Model과 ViewName:String으로 분리하게 사용하게 되었
     * @return
     */
    @GetMapping("/mav-forward")
    public ModelAndView mavForwad(ModelAndView mav){
        // view 지정
        mav.setViewName("result:/");
        return mav;
    }

}