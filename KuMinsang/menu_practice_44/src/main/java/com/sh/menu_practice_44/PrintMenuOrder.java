package com.sh.menu_practice_44;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/printMenuOrder")
public class PrintMenuOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //사용자 입력값 가져오기
        String mainMenu = request.getParameter("mainMenu");
        String sideMenu = request.getParameter("sideMenu");
        String drinkMenu = request.getParameter("drinkMenu");

        //업무로직 결과 가져오기
        int price = (int)request.getAttribute("price");

        //응답 HTML 작성
        //응답헤더 작성
        response.setContentType("text/html; charset=UTF-8");
        //응답 바디 작성
        PrintWriter out = response.getWriter();
        String html = """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>주문 결과 페이지</title>
                <style>
                span#mainMenu {
                	color: navy;
                	font-size: 2em;
                }
                                
                span#sideMenu {
                	color: indigo;
                	font-size: 1.5em;
                }
                                
                span#drinkMenu {
                	color: yellowgreen;
                }
                                
                span#price {
                	color: maroon;
                	font-size: 2.5em;
                }
                </style>
                </head>
                <body>
                	<h2>감사합니다.</h2>
                	<span id="mainMenu">%s</span>,
                	<span id="sideMenu">%s</span>,
                	<span id="drinkMenu">%s</span>을/를 주문하셨습니다.
                	<br /> 총 결제금액은
                	<span id="price">%d 원</span> 입니다.
                </body>
                </html>
                """.formatted(mainMenu, sideMenu, drinkMenu, price);
        out.println(html);
    }
}