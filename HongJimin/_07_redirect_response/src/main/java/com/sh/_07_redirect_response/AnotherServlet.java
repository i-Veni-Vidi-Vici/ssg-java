package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {

    /**
     * redirect 응답 이후 요청은 GET방시으로 처리된다.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getAttribute("sample"));

        // 응답 헤더
        response.setContentType("text/html; charset=UTF-8");
//        response.setContentType("text/plain; charset=UTF-8");
        // 응답 바디
        PrintWriter out = response.getWriter();
        out.println("""
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>Another</title>
                    </head>
                    <body>
                        <h1>🐱‍💻Another🐱‍💻</h1>
                    </body>
                </html>
                """);


    }

}