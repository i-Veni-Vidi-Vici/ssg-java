package com.sh._07_redirect_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    /**
     * redirect응답이후 요청은 GET방식으로 처리된다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 응답헤더
        response.setContentType("text/plain; charset=UTF-8");
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