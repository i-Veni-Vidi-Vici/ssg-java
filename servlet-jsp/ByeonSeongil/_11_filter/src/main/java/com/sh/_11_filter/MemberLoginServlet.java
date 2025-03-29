package com.sh._11_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청 핸들링
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        System.out.println(userId + ", " + password);

        // 2. 업무로직 (application속성 조회)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ServletContext application = getServletContext();
        List<Member> members = (List<Member>) application.getAttribute("members");
        Optional<Member> optMember = members.stream()
                .filter(
                    (member) -> 
                        userId.equals(member.getUserId()) && encoder.matches(password, member.getPassword()))
                .findFirst();
        // 인증 여부 분기처리
        if (optMember.isPresent()) {
            System.out.println("로그인 성공! " + optMember.get());
            // 세션에 로그인 객체를 저장
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", optMember.get());
        }
        else {
            System.out.println("로그인 실패!");
        }


        // 3. 응답 (리다이렉트)
        response.sendRedirect(request.getContextPath() + "/"); // /11_filter -> /11_filter/ 리다이렉트 횟수 줄이기
    }
}