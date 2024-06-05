package com.sh._07_redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Redirect 응답
 * - /a로 요청이 오면 , /b로 다시 요청 보내도록 처리 할 수 있다.
 * - 3xx번대 리다이렉트 응답코드를 발송한다.
 * - 이를 응답받은 클라이언트는 응답헤더에 작성된 Location값으로 즉시 재요청을 보낸다.
 */
//@WebServelt(urlPatterns = {"/redirect"};
//@WebServelt(urlPatterns = {"/redirect"};
//@WebServelt(urlPatterns = {"/redirect","/redirect2","/redirect3"};
@WebServlet("/redirect") //redirect로 설정하면 에러 생김
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/redirect 요청 ! ");
        //response.sendRedirect("https://www.naver.com"); // 리다이렉션 설정하고, 사용자에게 보여줄 브라우저 입력
//        response.sendRedirect("another"); // 상대주소(/07_redirect_response/redirect -> /07_redirect_response/another)

        System.out.println(request);

        response.sendRedirect("/07_redirect/anothoer");//절대주소 ( 브라우저에서 요청할 주소이므로 application.context값을 추가해서 보내줘야 한다.

    }


}









