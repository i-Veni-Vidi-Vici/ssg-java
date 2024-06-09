package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Status Code
 * - 응답 상태코드. 응답상태를 의미하는 숫자값.
 * - 1xx : 정보
 * - 2xx : 정상처리
 * - 3xx : 리다이렉트
 * - 4xx : 요청오류 (Client 오류)
 * - 5xx : 응답오류 (Server 오류)
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        throw new RuntimeException("ㅋㅋㅋㅎㅋ"); // 예외처리가 안된경우 500오류 발생
        // status code 지정
//        response.sendError(404);
//        response.sendError(HttpServletResponse.SC_NOT_FOUND, "이제 안 팔아여~");
        response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "죄송합니둥. 저희 개발자가 자고 있는 것 같아유🙏");
    }
}