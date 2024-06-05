package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/redirect")
//@WebServlet(value = "/redirect")
//@WebServlet(urlPatterns = {"/redirect"}) // 셋 중 하나를 쓰면 됨
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/redirect 요청!");
//        response.sendRedirect("https://naver.com"); // Location 주소값 설정

        // 매 요청마다 Request, Response 객체가 만들어진다. 요청간의 Request 객체를 공유할 수 없다.
        // 만약 요청 간의 데이터 등을 공유하려면, Session 객체를 이용해야 한다.
        System.out.println(request); //

//        response.sendRedirect("another"); // 상대주소 (/07_redirect_response/redirect -> /07_redirect_response/another)
        response.sendRedirect(request.getContextPath() + "/another"); // 절대 주소(브라우저에서 요청할 주소이므로 application context 표현))
    }

}