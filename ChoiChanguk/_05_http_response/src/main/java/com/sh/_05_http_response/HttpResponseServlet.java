package com.sh._05_http_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet이 하는 일
 * 1. 요청핸들링 : 사용자 입력값을 request객체로부터 꺼내서 자바변수에 대입
 * 2. 업무로직 (비니지스로직) : DB데이터 등록, 조회, 수정, 삭제, Service를 선정해서 업무위임
 * 3. 응답메시지 작성 (헤더값, 본문 내용(여기서 html 만들어준다))
 */

@WebServlet("/response")
public class HttpResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 요청핸들링
        String mode = request.getParameter("mode");
        // 2. 업무로직 처리
        // 3. 응답메시지 작성

        // 응답헤더부터 적는다

        // 인코딩 설정
//        response.setCharacterEncoding("UTF-8"); // 기본값, 생략 가능
//        response.setContentType("text/html"); // 응답 컨텐트에 타입(MIME)을 지정 (지금은 html이다)
        response.setContentType("text/html; charset=UTF-8"); // MIME + encoding , 이렇게도 가능

        // 응답 바디(헤더 설정 이후에 살정 할 것)
        // 응답본문을 작성을 위한 스트림객체가 이미 만들어져 있다. = 가져와서 쓰면 된다
        //ServletOutputStream outputStream = response.getOutputStream(); // 바이트 기반 출력스트림 // 파일 다운로드한다 이걸 쓰면 됨
        //PrintWriter는 문자기반 보조스트림, 부가기능 (print, println, ... )을 제공
        PrintWriter out = response.getWriter(); // 문자기반 출력스트림
        String message=switch (mode)
        {
            case "meat" ->"고기고기 입니다";
            case "vegi" -> "야채야채 입니다";
            default -> throw new IllegalStateException("mode error : " + mode);
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
        out.close(); // 출력스트림 닫기 -> 실제 쓰기 작업이 생성

        // 응답헤더 확인
        response.getHeaderNames()
                .stream()
                .forEach((header)-> System.out.println(header + " = "+response.getHeader(header)));
        // 응답
    }
}