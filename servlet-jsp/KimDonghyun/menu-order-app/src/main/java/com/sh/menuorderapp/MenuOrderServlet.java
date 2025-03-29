package com.sh.menuorderapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menuOrder")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.전송값 꺼내서 변수에 기록하기.
        String mainMenu = req.getParameter("mainMenu");
        String sideMenu = req.getParameter("sideMenu");
        String drinkMenu = req.getParameter("drinkMenu");
        System.out.println("mainMenu = " + mainMenu);
        System.out.println("sideMenu = " + sideMenu);
        System.out.println("drinkMenu = " + drinkMenu);

        //2.비지니스 로직 - 결제금액
        int price = 0;
        price += switch (mainMenu) {
            case "한우버거" -> 5000;
            case "밥버거" -> 4500;
            case "치즈버거" -> 4000;
            default -> 0;
        };
        price += switch (sideMenu) {
            case "감자튀김" -> 1500;
            case "어니언링" -> 1700;
            default -> 0;
        };
        price += switch (drinkMenu) {
            case "콜라", "사이다" -> 1000;
            case "커피" -> 1500;
            case "밀크쉐이크" -> 2500;
            default -> 0;
        };

        //4.실행결과 처리 및 view단 처리위임
        req.setAttribute("price", price);

        //RequestDispatcher(인터페이스)에 view단 jsp 경로 지정
        RequestDispatcher reqDispatcher = getServletContext().getRequestDispatcher("/printMenuOrder");
        reqDispatcher.forward(req, resp);

    }

}
