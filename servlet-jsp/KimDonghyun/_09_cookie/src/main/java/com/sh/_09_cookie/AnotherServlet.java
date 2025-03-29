package com.sh._09_cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청에 포함된 쿠키를 가져오기
        Cookie[] cookies = request.getCookies();

        // 쿠키가 존재하지 않는 경우, cookies는 null이다.
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + " = " + value);
            }
        }

        String cookiesLi = Arrays.stream(cookies)
                .map((cookie) -> "<li>" + cookie.getName() + " = " + cookie.getValue() + "</li>")
                .reduce("", (html, cookie) -> html + cookie);
        
        // 응답
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("""
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>응답</title>
                </head>
                <body>
                    <h1>응답</h1>
                    <h2>쿠키 내역</h2>
                    <ul>%s</ul>
                </body>
            </html>
            """.formatted(cookiesLi));

    }
}