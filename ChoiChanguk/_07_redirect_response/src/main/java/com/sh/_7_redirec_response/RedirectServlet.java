package com.sh._7_redirec_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Redirect 응답
 * - /a로 요청이 오면, /b로 다시 요청보내도록 처리할 수 있다.
 * - 3xx번대 리다이렉트, 응답코드를 발송한다.
 * - 이를 응답받은 클라리언트는 응답헤더에 작성된 Location 값으로 즉시 재요청을 보낸다
 *
 */
//@WebServlet(urlPatterns = "/redirect") 이렇게 써도 됨// 정확히 말하면 배열이기 때문에
//@WebServlet(urlPatterns = {"/redirect"},{"/print"})

@WebServlet(urlPatterns = {"/redirect","/print"}) //이렇게 해도 여러개가 켜지는게 아니라 이건 지금 서블릿의 주소이므로
// redirect로 해도 지금 서블릿 실행, print로 해도 지금 서블릿 실행
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/redirect 요청!");
//        response.sendRedirect("https://naver.com"); // Location 주소값 설정


        //매 요청마다 Request, Response 객체가 만들어진다, 요청간의 Request 객체를 공유할 수 없다.
        System.out.println(request);
        request.setAttribute("sample",1234);

//        response.sendRedirect("another"); // 상대주소(/07_redirect_response/redirect -> /07_redirect_response/another)
        response.sendRedirect(request.getContextPath()+"/another"); // 절대주소 (브라우져에서 요청할 주소이므로 application context

    }
}