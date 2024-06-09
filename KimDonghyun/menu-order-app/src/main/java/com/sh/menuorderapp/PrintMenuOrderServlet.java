package com.sh.menuorderapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/printMenuOrder")
public class PrintMenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자입력값 및 속성 가져오기
        String mainMenu = req.getParameter("mainMenu");
        String sideMenu = req.getParameter("sideMenu");
        String drinkMenu = req.getParameter("drinkMenu");
        int price = (int) req.getAttribute("price");
        
        // 2. 응답처리
        resp.setContentType("text/html; charset=UTF-8");
        // 응답바디
        PrintWriter out = resp.getWriter();
        out.println("""
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
                <span id="price">%d원</span> 입니다.
            </body>
            </html>
            """.formatted(mainMenu, sideMenu, drinkMenu, price));
    }
}