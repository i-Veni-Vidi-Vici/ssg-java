package com.sh._10_session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/another")
public class AnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request객체에서 속성값 가져오기 - 실패!
//        String firstName = (String) request.getAttribute("firstName");
//        String lastName = (String) request.getAttribute("lastName");

        // session객체에서 속성값을 가져온다.
        HttpSession session = request.getSession();
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");
        System.out.println(firstName + " " + lastName);

        // 응답
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("""
            <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>응답</title>
                </head>
                <body>
                    <h1>응답</h1>
                    <ul>
                        <li>firstName : %s</li>
                        <li>lastName : %s</li>
                    </ul>
                </body>
            </html>
            """.formatted(firstName, lastName));
    }
}