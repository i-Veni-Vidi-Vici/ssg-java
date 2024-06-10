package com.sh._10_session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Session 
 * - 서버에 클라이언트별로 데이터를 보관하는 기술
 * - request보다 긴 생명주기를 갖기때문에 로그인정보등을 보관하는데 사용한다.
 * - 기본유효시간은 30분이다. 필요에 따라 줄이거나 늘릴 수 있다.
 * 
 * 생명주기
 * 1. 클라이언트의 첫방문시 Session객체를 생성한다. id값을 Set-cookie 헤더값으로 전송한다.
 * 2. 브라우져는 session객체의 id를 쿠키로 저장한다.
 * 3. 클라이언트의 다음요청마다 JSESSIONID 쿠키를 전송해서 해당세션객체를 사용하게 된다.
 * 4-1. 세션만료시간이 지나도록 새요청이 없다면, 세션객체는 폐기된다.
 * 4-2. 직접 코드로써 세션을 만료시켜, 폐기할 수 있다.
 * 
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0. 요청 인코딩 설정 (getParameter 호출전에 설정)
        // 톰캣10 이전의 POST요청에는 기본 인코딩설정이 null이어서 아래 코드가 필요했다.
        // request.setCharacterEncoding("UTF-8");
        
        // 1. 요청 핸들링
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        System.out.println(firstName + " " + lastName);
        
        // request객체의 속성으로 저장. 다음 요청의 request객체에서 사용할 수 없다. 실패!
//        request.setAttribute("firstName", firstName);
//        request.setAttribute("lastName", lastName);

        // request객체보다 생명주기가 긴 session객체를 사용해야 한다.
        // 1. 생성된 session객체 있다면, id값을 통해 가져온다.
        // 2. 생성된 session객체가 없다면(혹은 만료되었다면), 새로 생성한다.
        HttpSession session = request.getSession();
        String id = session.getId(); // 클라이언트에서 쿠키로 전송한 JSESSIONID값 가져오기
        session.setMaxInactiveInterval(60 * 10); // 세션만료시간설정2 (초단위) - 우선순위가 더 높다.
        System.out.println("id = " + id);

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        // 2. 업무로직
        // 3. 응답 작성
        response.sendRedirect("another");
    }
}