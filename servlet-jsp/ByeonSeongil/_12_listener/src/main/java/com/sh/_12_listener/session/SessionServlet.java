package com.sh._12_listener.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 속성 추가
        session.setAttribute("username", "honggd");
        session.setAttribute("age", 33);

        // 속성 제거
        session.removeAttribute("age");
        
        // 속성 대체
        session.setAttribute("username", "sinsa");

        // Member객체 속성 등록 (HttpSessionBindingListener 구현체)
        session.setAttribute("member", new Member("honggd", "1234", "홍길동"));

        // 세션 만료처리
        session.invalidate();
    }
}