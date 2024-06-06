package com.sh._06_forward_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * client : / -> http://localhost:8080 "/"의 /임
 *
 * server(project 안에서) : / -> "/"06_forward_response :
 */
@WebServlet("/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //사용자 입력값 가져오기
        String category = request.getParameter("category");
        System.out.println("PrintServlet : " + category);
        //업무로직 결과 : Request속성에서 menus를 꺼내야하마.
        List<String> menus = (List<String>) request.getAttribute("menus");
        System.out.println("PrintServlet : " + menus);
        String menuLi = menus.stream()
                .reduce("",(html, menu)->html + "<li>" + menu + "</li>");
        //reduce -> 여러개 문자열을 하나로 합치는 역할을 많이함,

        // 3. 응답 html 작성
        //응답 헤더부
        response.setContentType("text/html; charset=UTF-8");
        //응답 바디부
        PrintWriter out = response.getWriter();
        String html = """
               <!DOCTYPE html>
               <html>
                   <head>
                       <meta charset="UTF-8">
                       <title>응답</title>
                   </head>
                   <body>
                       <h1>카테고리별 메뉴</h1>
                       <h2>선택하신 카테고리는 %s입니다.</h2>
                       <ul>%s</ul>
                       <button type = "button" onclick="history.back();">뒤로가기 </button>
//                      <!-- client에서 요청하는 주소는 application context부터 시작해야한다. (절대주소) -->
                       <a href="%s">뒤로가기  </a>
                   </body>
               </html>
                """.formatted(category, menuLi, request.getContextPath());// %s 부분이 동적으로 처리할 코드

        //클라이언트 호출이라서 뒤로가기나 앞으로 가기 할때는 -> getContextPath()를 붙여야 한다.
        out.println(html);
    }


}









