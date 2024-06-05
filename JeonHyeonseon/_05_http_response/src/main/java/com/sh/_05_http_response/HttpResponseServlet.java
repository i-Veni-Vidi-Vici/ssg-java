package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet이 하는 일
 * 1. 요청핸들링 : 사용자입력값을 request객체로부터 꺼내서 자바변수에 대입
 * 2. 업무로직(비즈니스로직) : DB데이터 등록, 조회, 수정, 삭제 (CRUD). Service를 선정해서 업무위임.(서비스야. 너가 해봐)
 * 3. 응답메시지 작성 (헤더값, 본문내용) : html생성
 */
@WebServlet("/response")
public class HttpResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청핸들링
        // 모드값을 주세요.
        String mode = request.getParameter("mode");
        System.out.println(mode);
        // 2. 업무로직
        // 3. 응답메시지 작성

        // 응답헤더
        // 인코딩 설정
//        response.setCharacterEncoding("UTF-8"); // 기본값이므로 생략 가능
//        response.setContentType("text/html"); // 응답 컨텐트에 타입(MIME) 지정
                // MIME, Multipurpose Internet Mail Extensions)는 전자 우편을 위한 인터넷 표준 포맷
        response.setContentType("text/html; charset=UTF-8"); // MIME + encoding 동시작성

        // 응답바디 (주의 : 헤더설정 이후 작성할 것)
        // 응답본문 작성을 위한 스트림객체가 이미 만들어져 있다.
//        ServletOutputStream outputStream = response.getOutputStream(); // 바이트기반의 출력스트림
        // PrintWriter는 문자기반보조스트림. 부가기능(print, println, ...)을 제공.
        PrintWriter out = response.getWriter();// 문자(텍스트)기반의 출력스트림
        String message = switch (mode) {
            case "chicken" -> "🍖🍗🥩🐷";
            case "vegi" -> "🥗🥙🥦🥬🥒🥕";
            default -> throw new RuntimeException("no mode");
        };
        String html = """
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>응답</title>
                </head>
                <body>
                    <h1>응답</h1>
                    <h2>%s</h2>                  
                </body>
            </html>
            """.formatted(message);
        out.print(html);
        out.close(); // 출력스트림 닫기 -> 실제 쓰기작업 생성

        // 응답헤더 확인 (쓰기작업 이후 확인 가능)
        response.getHeaderNames()
                .stream()
                .forEach((header) -> System.out.println(header + " = " + response.getHeader(header)));
    }
}