package com.sh._06_forward_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 요청을 받은 Servlet은 요청처리에 있어 다른 Servlet에게 위임할 수 있다.
 * - RequestDispatcher#forward(request, response)
 * - 첫번째 서블릿이 요청핸들링/업무로직 담당하고, 두번째 서블릿이 응답을 작성하는 경우가 많다
 */

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, List<String>> menuMap = Map.of(
                "rice", List.of("김밥", "김치볶음밥", "오므라이스"),
                "meat", List.of("대패삼겹살", "스테이크", "치킨", "족발"),
                "vegetable", List.of("샐러드", "포케", "콩고기 탕수육")
        );

        // 1. 요청 핸들링
        String category = request.getParameter("category");
        System.out.println(category); // rice | meat | vegetable

        // 2. 업무로직 (db 데이터 crud)
        List<String> menus = menuMap.get(category);
        System.out.println(menus);
        // 위임할 서블릿에게 위 데이터가 전송되어야 한다.
        // Request객체의 속성으로 저장하면, 위임받은 서블릿에서 꺼내쓸 수 있다.
        request.setAttribute("menus", menus);

        // 3. 다른 서블릿으로 forward처리
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/print");
        requestDispatcher.forward(request, response);
    }
}