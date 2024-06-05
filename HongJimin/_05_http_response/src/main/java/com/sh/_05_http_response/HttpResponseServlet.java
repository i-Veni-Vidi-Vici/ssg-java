package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 ## Servlet이 하는 일
 1. 요청 핸들링 : 사용자 입력 값을 request 객체로부터 꺼내서 자바 변수에 대입
 2. 업무로직(비즈니스로직) : DB 데이터 등록, 조회, 수정, 삭제(CRUD), Service를 선정해서 업무 위임
 3. 응답 메세지 작성(헤더 값, 본문 내용)
 */
@WebServlet("/response")
public class HttpResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 요청 핸들링
        String mode = request.getParameter("mode");// mode를 써야 mode에 뭐가 달려져 왓어? 라고 옴
        System.out.println(mode);

        //2. 업무로직
        //3. 응답메세지 작성

        // 응답 헤더
        // 인코딩 설정
//        response.setCharacterEncoding("UTF-8"); // 기본값 -> 생략 가능
//        response.setContentType("text/html");// 응답 컨텐트 타입(MIME) 지정
        response.setContentType("text/html; charset=UTF-8");// MIME + encoding 동시 작성

        // 응답 바디
        // 응답 본문을 작성하기 위한 스트림객체가 이미 만들어져 있음
//        ServletOutputStream outputStream = response.getOutputStream(); // 바이트 기반 출력 스트림이 이미 만들어져 있음
        // ## PrintWriter = 문자기반 보조 스트림
        // 부가기능(print, println)
        PrintWriter out = response.getWriter(); // 문자 기반 출력 스트림을 만들 수 있음
        String message = switch (mode) {
            case "cat" -> "🐱‍💻🐱‍👓🐱‍🚀🐱‍🏍🐱‍👤";
            case "vegi" -> "🌮🥑🥒🥬";
            default -> throw new RuntimeException("no mode");
        }; // 🌟사용자의 입력에 따라 달라짐 -> 동적이다~~~!!

        String html = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <title>응답</title>
                    </head>
                    <body>
                        <h1>응답<h1>
                        <h2>%s<h2>
                    </body>
                </html>
                """.formatted(message); // %s자리에 채워주세요~~ 하는 것
        out.print(html);
        out.close(); // 출력 스트림 닫기 -> 실제 쓰기 작업

        //응답 헤더 확인
        response.getHeaderNames()
                .stream()
                .forEach((header) -> System.out.println(header + " = " + response.getHeader(header)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}