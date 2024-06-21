package com.sh.authapp.controller;

import com.sh.authapp.model.dto.MemberDto;
import com.sh.authapp.model.service.AuthQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes({"name"})
public class AuthController {
    private final AuthQueryService authQueryService;

    @PostMapping("/login")
    public String login(Model model, @RequestParam String id, @RequestParam String password) {
        log.info("POST /member/login");
        log.debug("id/password = {}/{}", id, password);

        MemberDto memberDto = authQueryService.findByLoginInfo(id, password); // 로그인 정보 불러오기
        log.debug("memberDto = {}", memberDto);
        model.addAttribute("name", memberDto.getName()); // 사용자 이름 세션에 저장
        return "redirect:/"; // 인덱스 페이지로 리다이렉트
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        log.info("Get /member/logout");

        sessionStatus.setComplete(); // 세션 폐기
        return "redirect:/";
    }

    @GetMapping("/membersOnly")
    public String membersOnly(Model model) {
        log.info("GET /member/membersOnly");
        return "/member/membersOnly";
    }
}
