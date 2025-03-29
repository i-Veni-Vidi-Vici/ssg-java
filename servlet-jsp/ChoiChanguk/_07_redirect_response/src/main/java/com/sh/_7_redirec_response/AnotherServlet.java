package com.sh._7_redirec_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        System.out.println(request.getAttribute("sample"));// redirect 와 다른 객체이기 때문에 다르다
        // 그니깐 서비스마다 객체가 새로 만들어진다
        // 응답헤더
        response.setContentType("text/html; charset=UTF-8");

        // 응답바디
        PrintWriter out=response.getWriter();
        String html= """
                <!DOCTYPE html>
                            <html>
                                <head>
                                    <meta charset="UTF-8">
                                    <title>여기는 another클래스 입니다</title>
                                </head>
                                <body>
                                    <h1>Another body입니다</h1>
                                </body>
                            </html>
                """;
        out.println(html);
    }

}