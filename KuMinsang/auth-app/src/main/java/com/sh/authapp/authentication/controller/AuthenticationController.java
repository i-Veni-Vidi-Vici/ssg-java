package com.sh.authapp.authentication.controller;

import com.sh.authapp.authentication.model.dto.MemberDto;
import com.sh.authapp.authentication.model.service.AuthenticationService;
import groovy.util.logging.Slf4j;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestParam(name="id") String userName,
                        @RequestParam(name="password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes){

        //입력값이 없으면 조기 리턴
        if(userName.isEmpty() || password.isEmpty()){
            redirectAttributes.addFlashAttribute("flashMessage", "아이디와 비밀번호를 입력하세요");
            return "redirect:/";
        }

        MemberDto requestMember = MemberDto.builder()
                .userName(userName)
                .password(password)
                .build();
        MemberDto member = authenticationService.authenticateMember(requestMember);
        if(member != null) {
            session.setAttribute("member", member);
        }else {
            redirectAttributes.addFlashAttribute("flashMessage", "아이디와 비밀번호가 일치하지 않습니다.");
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/membersOnly")
    public void membersOnly(){
    }

    //id, 비밀번호가 String이 아닐때 빈 입력값 예외처리용
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException e, RedirectAttributes redirectAttributes) {
        String name = e.getParameterName();
        redirectAttributes.addFlashAttribute("flashMessage", "아이디와 비밀번호를 입력하세요");
        return "redirect:/";
    }
}
