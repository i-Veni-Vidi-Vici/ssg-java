package com.sh._06_forward_response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자 입력값 가져오기
        String category = request.getParameter("category");
        System.out.println("PrintServlet : " + category);
        // Request 속성에서 menus(업무로직결과) 가져오기
        List<String> menus = (List<String>) request.getAttribute("menus");
        System.out.println("PrintServlet : " + menus);

        String menuLi = menus.stream()
                .reduce("", (html, menu) -> html + "<li>" + menu + "</li>");

        // 3. 응답 html 작성하기
        // 응답 헤더
        response.setContentType("text/html; charset-UTF-8");
        // 응답 바디
        PrintWriter out = response.getWriter();
        String html = """
            <!DOCTYPE html>
               <html>
               <head>
                  <meta charset="UTF-8">
                  <title>카테고리별 메뉴</title>
               </head>
               <body>
                  <h1>카테고리별 메뉴</h1>
                  <h2>선택하신 카테고리는 %s입니다.</h2>
                  <ul>%s</ul>
                  <button type="button" onclick="history.back();">뒤로가기</button>
                  <!-- client에서 요청하는 주소는 application context부터 시작해야 함 (절대주소) -->
                  <a href="%s">뒤로가기</a>
               </body>
            </html>
            """.formatted(category, menuLi, request.getContextPath());
        out.println(html);
    }
}