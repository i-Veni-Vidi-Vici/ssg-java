package com.sh._07_redirect_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    /**
     * redirect 응답이후 요청은 GET방식으로 처리된다.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request); // org.apache.catalina.connector.RequestFacade@7e4e04c3
        // 응답헤더
        // 문자그대로 전달
//        response.setContentType("text/plain; charset=UTF-8");
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
                                <h1>🐱‍🚀Another🐱‍🚀</h1>
                            </body>
                        </html>
            """);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}