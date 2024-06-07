package com.sh._05_http_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet이 하는 일
 * 1. 요청 핸들링 : 사용자 입력값을 request객체로부터 꺼내서 자바 변수에 대입
 * 2. 업무로직 ( 비지니스 로직 ) : DB 데이터 등록, 조회,수정, 삭제 (CRUD), 서비스를 선정해서 업무위임
 * 3. 응답메세지 작성 (헤더 값 , 본문 내용) html 생성
 */
@WebServlet("/response")
public class HttpResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 요청핸들링
        String mode = request.getParameter("mode");
        System.out.println(mode);
        //2. 업무로직
        //3. 응답메시지 작성

        // 응답헤더
        // 인코딩 설정
//        response.setCharacterEncoding("UTF-8"); //기본값 , 생략 가능
//        response.setContentType("text/html");// 응답 컨텍트 타입(MIME) 지정
        response.setContentType("text/html; charset=UTF-8");// MIME + 응답 컨텍트 타입(MIME) 지정


        //응답바디 (헤더 설정 이후 작성할것)
        //응답 본문을 작성을 위한 스트림객체가 이미 만들어져 있다.
        //ServletOutputStream outputStream = response.getOutputStream(); //바이트 기반 출력 스트림 -> 파일 다운로드 할 떄 사용

        //PrintWriter는 문자기반 보조소트림 . 부가기능(println, 부가기능(print, println, ...)을 제공
        PrintWriter out = response.getWriter();//문자 기반 출력 스트림
        String message = switch (mode) {
            case "meat" -> "🥩🥩🥩";
            case "vegi" -> "🌽🌽🌽";
            default -> throw new RuntimeException("no mode");
        };

        String html = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset ="UTF-8"
                        <title> 응답 </title>
                    </head>
                    
                    <body>
                        <h1> 응답 </h1>
                        <h2> %s </h2>
                    </body>
                </html>
                """.formatted(message);
        out.print(html);
        out.close(); // 출력 스트림 닫기 -> 실제 쓰기 작업

        //응답 헤더 확인(쓰기 작업 이후 확인 가능)
        response.getHeaderNames()
                .stream()
                .forEach((header) -> System.out.println(header + " = " + response.getHeader(header)));

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}









