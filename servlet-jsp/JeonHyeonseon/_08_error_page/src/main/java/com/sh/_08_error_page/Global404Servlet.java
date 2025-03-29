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
        // 에러/예외관련 속성확인
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            System.out.println(attributeName + " = " + request.getAttribute(attributeName));
        }
        /*
        Global404Servlet
        jakarta.servlet.forward.request_uri = /08_error_page/%E3%85%93%E3%85%8F%E3%85%98%E3%85%93%EB%9F%AC%E3%85%97%EB%9D%BC
        jakarta.servlet.forward.context_path = /08_error_page
        jakarta.servlet.forward.servlet_path = /ㅓㅏㅘㅓ러ㅗ라
        jakarta.servlet.forward.mapping = org.apache.catalina.core.ApplicationMapping$MappingImpl@5fe762f1
        jakarta.servlet.error.message = 요청된 리소스 [/08_error_page/%E3%85%93%E3%85%8F%E3%85%98%E3%85%93%EB%9F%AC%E3%85%97%EB%9D%BC]은(는) 가용하지 않습니다.
        jakarta.servlet.error.servlet_name = default
        jakarta.servlet.error.request_uri = /08_error_page/%E3%85%93%E3%85%8F%E3%85%98%E3%85%93%EB%9F%AC%E3%85%97%EB%9D%BC
        jakarta.servlet.error.status_code = 404
         */

        // 응답 html처리
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
                    <h1 style="text-align: center; font-size: 300px; margin: 100px 0;">텅</h1>
                    <p style="text-align: center;">요청하신 페이지는 존재하지 않습니다.</p>
                    <p style="text-align: center; color: blue">%s</p>
                </body>
            </html>
            """.formatted(request.getAttribute("jakarta.servlet.error.message")));
    }
}