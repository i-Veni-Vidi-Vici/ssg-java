package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Status Code
 * - 응답 상태코드. 응답상태를 의미하는 숫자값.
 * - 1xx 정보
 * - 2xx 정상처리
 * - 3xx 리다이렉트
 * - 4xx 요청오류 (Client 오류)
 * - 5xx 응답오류 (Server 오류)
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        throw new RuntimeException("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"); // 예외처리안된경우 500오류발생
        // status code 지정
//        response.sendError(404);
//        response.sendError(HttpServletResponse.SC_NOT_FOUND, "이제 안 팔아요~"); // 404 error
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "죄송합니다. 저희 개발자가 놀고 있는거 같습니다ㅠ");
    }
}