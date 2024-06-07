package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Status Code
 * - 응답 상태 코드. 응답상태를 의미하는 숫잡값.
 * - 1xx
 * - 2xx : 정상처리
 * - 3xx : 리다이렉트(Redirect)
 * - 4xx : 요청 오류(Client 오류 )
 * - 5xx : 응답 오류 (Server 오류)

 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("zz");
        //에러처리 하지 않으면 500오류 발 생
        //status code 지정
//        response.sendError(404);
//        response.sendError(HttpServletResponse.SC_NOT_FOUND, "없어요");
//        response.sendError((HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"죄송합니다");
    }


}









