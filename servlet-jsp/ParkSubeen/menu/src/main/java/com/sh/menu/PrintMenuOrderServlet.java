package com.sh.menu;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/printMenuOrder")
public class PrintMenuOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 메인메뉴
        String mainMenu = request.getParameter("mainMenu");
        // 사이드메뉴
        String sideMenu = request.getParameter("sideMenu");
        // 음료메뉴
        String drinkMenu = request.getParameter("drinkMenu");
        // 금액
        String price = (String) request.getAttribute("price");

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
                	<span id="price">%s원</span> 입니다.
                </body>
                </html>
                """.formatted(mainMenu, sideMenu, drinkMenu, price);
        out.println(html);
    }
}