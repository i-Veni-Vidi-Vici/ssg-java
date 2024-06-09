package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    /**
     * redirect응답 이후 요청은 GET방식으로 처리된다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request); // org.apache.catalina.connector.RequestFacade@3a4b13bf

        // 응답헤더
        response.setContentType("text/html; charset=UTF-8");
//        response.setContentType("text/plain; charset=UTF-8"); // plain일 땐 html코드 그대로 나온다.
        // 응답바디
        PrintWriter out = response.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>Another</title>
                    </head>
                    <body>
                        <h1>🍧Another🍧</h1>
                    </body>
                </html>
                """);
    }
}