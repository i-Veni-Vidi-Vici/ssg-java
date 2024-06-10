package com.sh._12_listener.application;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();

        // 속성 추가
        application.setAttribute("username", "honggd");
        application.setAttribute("age", 33);

        // 속성 제거
        application.removeAttribute("age");
        
        // 속성 대체
        application.setAttribute("username", "sinsa");
    }
}