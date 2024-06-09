package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;


/**
 * Status Code
 * - 응답 상태코드. 응답상태를 의미하는 숫자값
 * - 1xx : 정보같은 느낌
 * - 2xx : 정상처리(조회, 등록, 삭제 등등)
 * - 3xx : 리다이렉트
 * - 4xx : 요청오류, client 오류라고 한다
 * - 5xx : 응답오류, server 오류라고 한다 // 자바코드 중에 예외라던지 등등
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // throw new RuntimeException("오류입니다"); // 예외처리 안된 경우 500오류
        // status code 지정
        // response.sendError(404);

//        response.sendError(HttpServletResponse.SC_NOT_FOUND," 이제 서버 제공 안해요");
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"죄송합니다 개발자가 일을 안했네요");
    }

}