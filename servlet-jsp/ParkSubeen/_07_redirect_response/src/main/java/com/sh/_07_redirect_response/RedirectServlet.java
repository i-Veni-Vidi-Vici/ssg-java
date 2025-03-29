package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


/**
 * Redirect 응답
 * - /a로 요청이 오면, /b로 다시 요청보내도록 처리할 수 있다.
 * - 3xx번대 리다이렉트 응답코드를 발송한다.
 * - 이를 응답받은 클라이언트는 응답헤더에 작성된 Location값으로 즉시 재요청을 보낸다.
 */
//@WebServlet(urlPatterns = {"/redirect"})
//@WebServlet(value = {"/redirect"})
//@WebServlet({"/redirect"})
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/redirect 요청!");
//        response.sendRedirect("https://naver.com"); // Location 주소값 설정

        // 매 요청마다 Request, Response객체가 만들어진다. 요청간의 Request객체를 공유할 수 없다.
        // 만약 요청간의 데이터등을 공유하려면, Session객체를 이용해야 한다.
        System.out.println(request); // org.apache.catalina.connector.RequestFacade@41e2a7af

//        response.sendRedirect("another"); // 상대주소(/07_redirect_response/redirect -> /07_redirect_response/another)
//        response.sendRedirect("/07_redirect_response/another"); // 절대주소 (브라우져에서 요청할 주소이므로 application context를 포함)
        response.sendRedirect(request.getContextPath() + "/another"); // 절대주소 (브라우져에서 요청할 주소이므로 application context를 포함)
    }
}