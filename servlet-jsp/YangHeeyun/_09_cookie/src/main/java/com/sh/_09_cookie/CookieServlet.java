package com.sh._09_cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Cookie
 * - Client(브라우져)에 데이터를 보관하는 기술
 *
 * 이용순서
 * 1. 서버에 쿠키를 생성
 * 2. 응답헤더 Set-cookie에 쿠키 전송
 * 3. 브라우저 해당쿠키를 저장
 * 4. 클라이언트 요청시에 저장된 쿠키를 함께 전송(요청헤더 Cookie)
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자입력값 핸들링
        String username = request.getParameter("username");
        System.out.println(username);

        // 쿠키 생성
        Cookie cookie = new Cookie("username", username); // 매개변수 String,String 숫자를 저장해도 문자로 저장된다.
        // 쿠기 유효기간 설정(브라우져에 보관할 기간. 초단위 작성)
        cookie.setMaxAge(60 * 60 * 24); // 유효기간 하루 기준으로 작성된 것(하루 보관하고 하루 지나면 자동삭제)
        // 쿠키를 이용할 요청경로
        cookie.setPath("/"); // /(슬래시)하위의 모든 요청에 쿠키를 함께 전송
        // 응답에 쿠키를 추가(n개 추가가능)
        response.addCookie(cookie);

        // 응답 작성 (redirect)
        response.sendRedirect(request.getContextPath()); // 원래 있던 페이지로 돌아가기,  /09_cookie를 하드코딩한 것 과 똑같다.
    }
}