package com.sh._09_cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * session = 서버쪽에 저장
 * client = 쿠기에 저장
 *
 * 이용순서
 * 1. 서버에서 쿠기들 생성
 * 2. 응답헤더 Set-cookie에 쿠키전송
 * 3. 브라우저 해당쿠기를 저장
 * 4. 클라이언트 요청시에 정장된 쿠기를 하께 전송 (요청헤더 Cookie)
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // a사용자입력 값 핸들링
        String username=request.getParameter("username");
        System.out.println(username);
        // 쿠키생성

        //응답작성 (redirect)
        Cookie cookie=new Cookie("username",username);

        //쿠기 유효기간 (브라우져에 보관한 기간, 주단위 작
        cookie.setMaxAge(60*60*24);

        //쿠키를 이용할 요청경로
        cookie.setPath("/"); // 하위의 모든 요청에 쿠키를 함께 전송

        // 응답에 쿠키를 추가(n개 추가가능)
        response.addCookie(cookie);

        //응받작성(redirect
        response.sendRedirect(request.getContextPath()); // /09_cookie와 같다
    }
}