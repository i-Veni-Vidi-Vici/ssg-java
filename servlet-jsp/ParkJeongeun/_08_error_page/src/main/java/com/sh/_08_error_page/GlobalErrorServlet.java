package com.sh._08_error_page;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/error")
public class GlobalErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GlobalErrorServlet");
        // 에러/예외 관련 속성확인
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            System.out.println(attributeName + " = " + request.getAttribute(attributeName));
        }
        // 응답 html 처리
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("""
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>오류</title>
                </head>
                <body>
                    <h1 style="text-align: center; font-size: 300px;">헙</h1>
                    <p style="text-align: center;">불편을 드려 죄송합니다.</p>
                    <p style="text-align: center; color: red;">%s</p>
                </body>
            </html>
            """.formatted(request.getAttribute("jakarta.servlet.error.message")));
    }
}