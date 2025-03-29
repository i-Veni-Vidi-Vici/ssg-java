package com.sh._10_session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/deleteSession")
public class DeleteSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션 속성에 저장된 데이터 확인
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            Object value = session.getAttribute(name);
            System.out.println(name + " = " + value);
        }
        
        // 1. 세션 속성 하나 삭제
//        session.removeAttribute("firstName");
        
        // 2. 세션 객체 만료
        session.invalidate(); // 세션객체 폐기

        // 응답 리다이렉트
        response.sendRedirect(request.getContextPath() + "/");
    }
}