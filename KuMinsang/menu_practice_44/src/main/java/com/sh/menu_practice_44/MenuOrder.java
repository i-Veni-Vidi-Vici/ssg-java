package com.sh.menu_practice_44;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/menuOrder")
public class MenuOrder extends HttpServlet {
    Map<String, Integer> menuMap = Map.of(
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

        String mainMenu = request.getParameter("mainMenu");
        String sideMenu = request.getParameter("sideMenu");
        String drinkMenu = request.getParameter("drinkMenu");
        int totalPrice = menuMap.get(mainMenu) + menuMap.get(sideMenu) + menuMap.get(drinkMenu);
        System.out.println(mainMenu);
        System.out.println(sideMenu);
        System.out.println(drinkMenu);
        System.out.println(totalPrice);

        request.setAttribute("price", totalPrice);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/printMenuOrder");
        requestDispatcher.forward(request, response);
    }
}