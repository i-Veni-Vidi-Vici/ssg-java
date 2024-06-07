package com.sh._03_requet_parameter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

@WebServlet("/test")
public class RequestParameterServlet extends HttpServlet {
    /**
     * GET방식 요청에서 사용자입력값은 Query String(직렬화) 형태로 서버에 전달된다.
     * - http://localhost:8080/03_request_parmeter/test?name=홍길동&age=33&married=true
     * name=홍길동&age=33&married=true : QueryString부분은 request객체 안에서 HashMap으로 관리된다.
     * - HttpServletRequest#getParameter(name) : String으로 처리할 수 있다.
     * - 모든 사용자 입력값은 문자열로써 처리된다.
     * - 단순 조회 요청(멱동)으 전송 방식 GET을 사용한다.
     * 멱등 : 요청을 했을 때 데이터의 상태가 바뀌지 않는 것을 멱등이라고 함. 단순 조회
     *
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //사용자 입력값 QueryString 가져오기
        System.out.println("doGet");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday =
                LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ISO_DATE);
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name =" + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("hobbies = " + Arrays.toString(hobbies));
        System.out.println("national = " + national);

    }

    /**
     * POST 요청에서 사용자 입력값은 http요청 메세지의 본문 영역에 작성된다.(url에 노출되지 않는다.)
     * 동일하게 QueryString 형태로 전달
     * DML 쿼리로 처리 되야 하는 요청은 전송방식 POST를 사용한다.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        //인코딩된 값 확인하기
        System.out.println(req.getCharacterEncoding());//default : utf-8
        //인코딩 설정하기
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday =
                LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ISO_DATE);
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name =" + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("hobbies = " + Arrays.toString(hobbies));
        System.out.println("national = " + national);

        Map<String, String[]> parameterMap = req.getParameterMap();
        //Parametermap을 통해서 사용자의 입력값 조회
        parameterMap.forEach((k,v) -> {
            System.out.println(k + " = " + Arrays.toString(v));
        });
    }
}
