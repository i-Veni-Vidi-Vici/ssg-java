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
        System.out.println("GlobalErrorServlet 입니다");
        // 에러/예외관련 속성확인

        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements())
        {
            String attributeName=attributeNames.nextElement();
            System.out.println(attributeName +" "+request.getAttribute(attributeName));
        }
        //예외 관련된 정보들
//        jakarta.servlet.forward.request_uri /08_error_page/test
//        jakarta.servlet.forward.context_path /08_error_page
//        jakarta.servlet.forward.servlet_path /test
//        jakarta.servlet.forward.mapping org.apache.catalina.core.ApplicationMapping$MappingImpl@1279936e
//        jakarta.servlet.error.message 에러유발입니다
//        jakarta.servlet.error.exception java.lang.RuntimeException: 에러유발입니다
//        jakarta.servlet.error.servlet_name com.sh._08_error_page.TestServlet
//        jakarta.servlet.error.request_uri /08_error_page/test
//        jakarta.servlet.error.exception_type class java.lang.RuntimeException
//        jakarta.servlet.error.status_code 500

        // 응답 html처리
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("""
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>오류</title>
                </head>
                <body>
                    <h1 style = "text-align : center; font-size :300px;">헉</h1>
                    <p style = "text-align : center;">불편을 드려 죄송합니다</p>
                    <p style = "text-align : center; color:red;">%s</p>
                </body>
            </html>
    """.formatted(request.getAttribute("jakarta.servlet.error.message")));


    }

}