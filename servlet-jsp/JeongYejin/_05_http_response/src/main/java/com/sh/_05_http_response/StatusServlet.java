package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Status Code
 * - 응답 상태코드. 응답상태를 의미하는 숫자값.
 * - 숫자세자릿수를 의미함
 * - 1xx 정보 (Information)
 * - 2xx 정상처리 (Successful)
 * - 3xx 리다이렉트 (Redirection)
 * - 4xx 요청오류(Client Error) ex. 404 Not Found
 * - 5xx 응답오류(Server Error)
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        throw new RuntimeException("ㅋㅋㅋㅋㅋㅋㅋ"); // 예외처리 안된 경우 500오류 발생
        // status code 지정
//        response.sendError(404);
//        response.sendError(HttpServletResponse.SC_NOT_FOUND, "이제 안 팔아요");
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "제송 .. 저희 개발자가 놀고 있어요 ..");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}