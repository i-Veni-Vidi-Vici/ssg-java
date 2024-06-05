package com.sh._09_cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Cookie : 데이터를 클라이언트 쪽에 보관하는것
 *  - 브라우저에 데이터를 보관하는 기술  = Client
 *  - 이용순서
 *  1. 서버에서 쿠키를 생성
 *  2. 응답헤더 set-cookie에 쿠키 전송
 *  3. 브라우져는 해당 쿠키를 저장
 *  4. 클라이언트 요청시에 저장된 쿠키를 함께 전송 (요청헤더 Cookie)
 *  - setCookie를 통해서 Client한테 데이터를 보관하라고 하는 것 .
 * Session : 데이터를 서버 쪽에 보관하는것
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //사용자 입력값 핸들링
        String username = request.getParameter("username");
        System.out.println(username);

        //쿠키 생성
        Cookie cookie = new Cookie("username", username); //숫자도 문자열로 저장
        //쿠키 유효기간 (브라우저에 보관한 기간. 초단위로 작성)
        cookie.setMaxAge(60 * 60 * 24); //유효기관 하루
        //쿠키를 이용한 요청 경로
        cookie.setPath("/"); // /하위의 모든 요청에 쿠키를 함께 전송
        //응답에 쿠키를 추가 (n개 추가 가능)
        response.addCookie(cookie);

        //응답 (redirect)
        response.sendRedirect(request.getContextPath()); // = 09_cookie
    }
}









