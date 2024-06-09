package com.sh._06_forward_response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 요청을 받은 서블릿은 요청처리에 있어 다른 Servlet에게 위임할 수 있다.
 * - RequestDispatcher#forward(request,response) -> 다른 Servlet에게 위이함 해주는 역할
 * - 첫번째 서블릿이 요청핸들링 /업무 로직을 담당하고, 두번째 서블릿ㅇ ㅣ응답을 작성하는 경우가 많다
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    Map<String, List<String>> menuMap = Map.of(
            "rice",List.of("김밥","김치볶음밥","오므라이스"),
            "meat",List.of("대패삼겹살","스테이크","치킨","족발"),
            "vegi",List.of("샐러드","포케","콩고기 탕수육")
    );
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 요청 핸들링
        String category = request.getParameter("category");
        System.out.println(category);
        //2. 업무 로직 (db 데이터 crud)
        List<String> menus = menuMap.get(category);
        System.out.println(menus);
        // 위임할 서블릿에게 위 데이터가 전송되어야 한다 .
        // Request 객체의 속성으로 저장 하면, 위임 받은 서블릿에서 꺼내 쓸 수 있다.
        // 별도의 메소드는 제공하지 않고, Request 객체에 해당하는 속성을 이용하여 저장 할 수 있따.
        request.setAttribute("menus", menus);


        //3. 다른 서블릿으로 forward
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/print"); // /print에 해당하는 서블릿에다가 위임
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}









