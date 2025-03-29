package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    /**
     * redirect 응답 이후 요청은 GET방식으로 처리된다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request);

        // 응답헤더
        response.setContentType("text/html; charset=UTF-8");
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
                <h1>🎸Another🎸</h1>
                </body>
            </html>
            """);
    }

}