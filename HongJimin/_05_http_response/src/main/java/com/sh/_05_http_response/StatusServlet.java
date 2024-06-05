package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * ## StatusServlet
 * - 응답 상태코드. 응답 상태를 의미하는 숫자값
 * - 1xx :
 * - 2xx : 정상 처리
 * - 3xx : 리다이렉트
 * - 4xx : 요청 오류(Client 오류)
 * - 5xx : 응답 오류(Server 오류)
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        throw new RuntimeException("ㅋㅋㅋㅋㅋㅋ"); // 예외처리 안된 경우 500 오류발생
//        response.sendError(404);
//        response.sendError(HttpServletResponse.SC_NOT_FOUND, "이제 안팔아요~");
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "죄송합니다. 저희 개발자가 놀고 있는 것 같네요😉");

    }


}