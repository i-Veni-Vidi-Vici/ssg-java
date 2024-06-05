package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



import java.io.IOException;

/**
 * Redirect 응답
 * - /a로 요청이 오면, /b로 다시 요청보내도록 처리할 수있다.
 * - 3xx번대 리다이렉트 응답코드를 발송한다
 * - 이를 응답받은 클라이언트는 응답헤더에 작성된 Loacation 값으로 즉시 재요청을 보낸다.
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/redirect 요청!");
//        response.sendRedirect("https://naver.com");// Location 주소 값 설정

//        response.sendRedirect("another");   //상대주소 (/07_redirect_response/redirect -> /07_redirect_response/another)
//        response.sendRedirect("/07_redirect_response/another"); //절대주소 (브라우저에서 요청할 주소이므로 application )
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath()+"/another"); //절대주소 (브라우저에서 요청할 주소이므로 application )

    }
}