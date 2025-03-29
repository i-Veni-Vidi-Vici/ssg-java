package com.sh.menu;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@WebServlet("/menuOrder")
public class MenuOrderServlet extends HttpServlet {
    Map<String, Integer> menuPrice = Map.of(
            "한우버거", 5000,
            "밥버거", 4500,
            "치즈버거", 4000,
            "감자튀김", 1500,
            "어니언링", 1700,
            "콜라", 1000,
            "사이다", 1000,
            "커피", 1500,
            "밀크쉐이크", 2500
    );

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 메인메뉴
        String mainMenu = request.getParameter("mainMenu");
        // 사이드메뉴
        String sideMenu = request.getParameter("sideMenu");
        // 음료메뉴
        String drinkMenu = request.getParameter("drinkMenu");
        // 금액
        String price = Integer.toString(menuPrice.get(mainMenu) + menuPrice.get(sideMenu) + menuPrice.get(drinkMenu));

        request.setAttribute("price", price);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/printMenuOrder");
        requestDispatcher.forward(request, response);
    }
}