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
     * GET방식 요청에서 사용자 입력값은 Query String(직렬화) 형태로 서버에 전달된다.
     *  - http://localhost:8080/03_request_parameter/test?name=홍길동&age=33&married=true 이런식으로 온다,query string부분은 request객체안에서 hashmap으로 파싱된다
     *  - HttpServletRequest#getParameter(name):String으로 처리할 수 있다.
     *  - 모든 사용자입력값은 문자열로써 처리된다. 중요하다!!!!!!!!!!!!!!
     *  ?뒤로 오는걸 Query String, 직렬화라고 한다
     *  http://localhost:8080/03_request_parameter/test?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=33&birthday=1999-09-09&gender=F&national=ko&hobbies=movie&hobbies=sleep
     *  name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=33&birthday=1999-09-09&gender=F&national=ko&hobbies=movie&hobbies=sleep 이렇게 날라온다
     *  - 단순조회요청은(멱등) 전송방식 : GET을 사용한다
     *  - 멱등 = 요청 전 후가 같다, 예를 들면 단순 조회 요청이 테이블을 변화 시키지 않는다
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGET방식 호출입니다");
        // 인코딩된 값 확인하기
        System.out.println(req.getCharacterEncoding());
        req.setCharacterEncoding("UTF-8");

        // 사용자 입력값 QueryString 가져오기
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday=LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ISO_LOCAL_DATE);
        String gender=req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name = " + name);
        System.out.println("age = "+age);
        System.out.println("birthday = "+birthday);
        System.out.println("gender = "+gender);
        System.out.println("national = "+ national);
        System.out.println("habbies[0] = "+hobbies[0]);
        System.out.println("habbies[1] = "+hobbies[1]);
    }

    /**
     * POST 요청에서 사용자 입력값은 http요청 메시지에 본문 영역에 작성된다. (url에 노출되지 않는다)
     * 동일하게 QueryString형태로 전달된다
     * http://localhost:8080/03_request_parameter/test 이렇게 톰캣 서버에 날라간다
     * - DML쿼리로 처리되야 하는 요청은 전송방식 POST를 사용한다
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPOST 호출입니다");
        // 사용자 입력값 QueryString 가져오기
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDate birthday=LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ISO_LOCAL_DATE);
        String gender=req.getParameter("gender");
        String national = req.getParameter("national");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name = " + name);
        System.out.println("age = "+age);
        System.out.println("birthday = "+birthday);
        System.out.println("gender = "+gender);
        System.out.println("national = "+ national);
        System.out.println("habbies[0] = "+hobbies[0]);
        System.out.println("habbies[1] = "+hobbies[1]);

        System.out.println("doPOST방식의 Map순회입니다");
        // ParameterMap을 통해서 사용자입력값 순회
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((k,v)->{
            System.out.println(k+" ="+ Arrays.toString(v));
        });
    }
}
