package com.sh._08_error_page;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/404")
public class Global404Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Global404Servlet");
        // 에러/예외 관련 속성 확인
        Enumeration<String> attributeNames = request.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            System.out.println(attributeName + " = " + request.getAttribute(attributeName));
        }
        /*
        jakarta.servlet.forward.request_uri = /08_error_page/test
        jakarta.servlet.forward.context_path = /08_error_page
        jakarta.servlet.forward.servlet_path = /test
        jakarta.servlet.forward.mapping = org.apache.catalina.core.ApplicationMapping$MappingImpl@2109b401
        jakarta.servlet.error.message = ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
        jakarta.servlet.error.exception = java.lang.RuntimeException: ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
        jakarta.servlet.error.servlet_name = com.sh._08_error_page.TestServlet
        jakarta.servlet.error.request_uri = /08_error_page/test
        jakarta.servlet.error.exception_type = class java.lang.RuntimeException
        jakarta.servlet.error.status_code = 500
        */

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
                        <h1 style = "text-align : center; font-size : 300px; margin : 100px 0; ">터엉</h1>
                        <p style = "text-align : center;">요청하신 페이지는 존재하지 않습니다.</p>
                        <p style = "text-align : center; color : red;">%s</p>
                    </body>
                </html>
                """.formatted(request.getAttribute("jakarta.servlet.error.message")));

    }

}