package com.sh.app.member.controller;

import com.sh.app.auth.principal.AuthPrincipal;
import com.sh.app.auth.service.AuthService;
import com.sh.app.member.dto.MemberRegisterRequestDto;
import com.sh.app.member.dto.MemberUpdateRequestDto;
import com.sh.app.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @GetMapping("/register")
    public void register() {}

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute MemberRegisterRequestDto dto,
            RedirectAttributes redirectAttributes) {
        // 1. 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encryptedPassword);
        log.debug("dto = {}", dto);
        // 2. 회원등록요청
        memberService.register(dto);
        redirectAttributes.addFlashAttribute("message", "축하합니다🎉 회원가입되었습니다.");
        return "redirect:/";
    }

    /**
     * 핸들러에서 SecurityContext의 보관중인 인증객체를 가져올수 있다.
     * - Authentication타입으로 의존 주입 받기
     * - @AuthenticationPrincipal 어노테이션으로 Principal객체(AuthPrincipal) 주입 받기
     */
    @GetMapping("/detail")
    public void detail(
            Authentication authentication,
            @AuthenticationPrincipal AuthPrincipal principal){
        log.debug("authentication = {}", authentication);
        // UsernamePasswordAuthenticationToken [
        //  Principal=AuthPrincipal(member=Member(memberId=leess, password=$2a$10$hVIhPltxg57y8KI8KLyxkOCEkTKGHJ/tXC21mGk0p3AaSMVOzhrQ., name=리순신, authorities=[ROLE_USER])),
        //  Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=988B1B48BFB50A8B4281B45B90078B3D],
        //  Granted Authorities=[ROLE_USER]]
        log.debug("principal = {}", principal);
        // AuthPrincipal(member=Member(memberId=honggd, password=$2a$12$q6KaO/EwS3W37BSc6SKiF.P8q5wRJAhjKZJ6DVrkxyfI8jeCR.d4m, name=홍길동, authorities=[ROLE_USER]))
    }

    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute MemberUpdateRequestDto dto,
            RedirectAttributes redirectAttributes) {
        // 1. db수정
        memberService.update(dto);
        // 2. SecurityContext하위 Authentication 갱신
        authService.updateAuthentication(dto.getMemberId());
        redirectAttributes.addFlashAttribute("message", "회원 정보를 수정했습니다.");
        return "redirect:/member/detail";
    }
}
