package com.sh._11_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청 핸들링
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        System.out.println(userId + ", " + password + ", " + name);
        
        // 암호화 처리
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        System.out.println(encodedPassword);

        // 2. 업무로직 (생략)
        ServletContext application = getServletContext(); // tomcat 구동시부터 종료까지의 생명주기를 가진 객체
        Object _members = application.getAttribute("members");
        if (_members == null) {
            // 첫 회원가입인 경우
            List<Member> members = new ArrayList<Member>();
            members.add(new Member(userId, encodedPassword, name));
            application.setAttribute("members", members);
        }
        else {
            // 기존회원이 존재하는 경우 (두번째부터)
            List<Member> members = (List<Member>) _members;
            members.add(new Member(userId, encodedPassword, name));
        }
        System.out.println(application.getAttribute("members"));

        // 3. 응답 (리다이렉트) POST방식에서는 redirect를 통해 url을 변경해준다. (새로고침 이슈 예방)
        response.sendRedirect(request.getContextPath() + "/");
    }
}