package com.sh._03_request_parameter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/test")
public class RequestParameterServlet extends HttpServlet {

    /**
     * GET방식 요청에서 사용자입력값은 Query String(직렬화)형태로 서버에 전달된다.
     * - http://localhost:8080/03_request_parameter/test?name=홍길동&age=33&married=true
     * - name=홍길동&age=33&married=true -> Query String 부분은 request객체 안에서 HashMap으로 관리된다.
     * - HttpservletRequest#getParameter(name):String로 처리할 수 있다.
     * - 모든 사용자입력값은 문자열로써 처리된다.
     * - 단순조회요청(멱등)은 전송방식 GET을 사용한다.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        // 인코딩된 값 확인하기
        System.out.println(req.getCharacterEncoding()); // UTF-8
        // 인코딩 설정하기
        req.setCharacterEncoding("UTF-8");

        // 사용자입력값 QueryString 가져오기
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday =
                LocalDate.parse(req.getParameter("birthday"),
                                DateTimeFormatter.ISO_DATE); // yyyy-MM-dd
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("national = " + national);
        System.out.println("hobbies = " + Arrays.toString(hobbies));
    }

    /**
     * POST요청에서 사용자입력값은 http요청메세지의 본문영역에 작성된다. (url에 노출되지 않는다.)
     * 동일하게 QueryString형태로 전달된다.
     * DML쿼리로 처리되야 하는 요청은 전송방식 POST를 사용한다.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        // 사용자입력값 QueryString 가져오기
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday =
                LocalDate.parse(req.getParameter("birthday"),
                        DateTimeFormatter.ISO_DATE); // yyyy-MM-dd
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("national = " + national);
        System.out.println("hobbies = " + Arrays.toString(hobbies));

        // ParameterMap을 통해서 사용자입력값 순회
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((k, v) -> {
            System.out.println(k + " = " + Arrays.toString(v));
        });
    }
}
