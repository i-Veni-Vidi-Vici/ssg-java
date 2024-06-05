package com.sh._07_redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    /**
     * redirect 응답 이후 요청ㅇ GET방식으로 처리된다.
     * @param request an {@link HttpServletRequest} object that contains the request the client has made of the servlet
     *
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 매 요청마다 Request, Response 객체가 만들어진다. 요청간의 Request객체를 공유할 수 없다.
        // 만약 요청간의 데이터 등을 공유하려면 request객체는 안된다. Session 객체를 이용해야 한다.
        System.out.println(request);

        //응답 헤더
        response.setContentType("text/html; charset=UTF-8");
        //응답 바디
        PrintWriter out = response.getWriter();
        out.println("""
                     <!DOCTYPE html>
                                 <html>
                                     <head>
                                         <meta charset="UTF-8">
                                         <title>Another</title>
                                     </head>
                                     <body>
                                        <h1> Another </h1>
                                     </body>
                                 </html>           
                """);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}









