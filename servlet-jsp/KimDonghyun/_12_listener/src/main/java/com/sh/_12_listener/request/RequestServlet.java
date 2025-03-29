package com.sh._12_listener.request;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 속성 추가
        request.setAttribute("username", "honggd");
        request.setAttribute("age", 33);

        // 속성 제거
        request.removeAttribute("age");
        
        // 속성 대체
        request.setAttribute("username", "sinsa");
    }
}