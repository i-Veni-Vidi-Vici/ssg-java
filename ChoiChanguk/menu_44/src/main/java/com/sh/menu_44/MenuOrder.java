package com.sh.menu_44;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/menuOrder")
public class MenuOrder extends HttpServlet {


    Map<String ,Integer> mainMenuPrice=new HashMap<>(){{put("한우버거",5000); put("밥버거",4500); put("치즈버거",4000);}};
    Map<String ,Integer> sideMenuPrice=new HashMap<>(){{put("감자튀김",1500); put("어니언링",1700);}};
    Map<String ,Integer> drinkMenuPrice=new HashMap<>(){{put("콜라",1000); put("사이다",1000); put("커피",1500); put("밀크쉐이크",2500);}};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mainMenu=req.getParameter("mainMenu");
        String sideMenu=req.getParameter("sideMenu");
        String drinkMenu=req.getParameter("drinkMenu");


        System.out.println("mainList : " + mainMenu);
        System.out.println("sideMenu : " + sideMenu);
        System.out.println("drinkMenu : " + drinkMenu);

        int sumPrice=mainMenuPrice.get(mainMenu)+sideMenuPrice.get(sideMenu)+drinkMenuPrice.get(drinkMenu);
        req.setAttribute("sumPrice",sumPrice);

        // 여기서 계산을 하고 출력하는 클래스로 forward를 한다
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/printMenuOrder");
        requestDispatcher.forward(req,resp);
    }
}
