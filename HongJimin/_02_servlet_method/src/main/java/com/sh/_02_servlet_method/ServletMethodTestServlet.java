package com.sh._02_servlet_method;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletMethodTestServlet", value = "/test") // 만약 값 하나만 속성명 없이 존재한다면, value라고 보면 됨
public class ServletMethodTestServlet extends HttpServlet {
    /**
     * 매 요청마다 service 메소드가 호출됨
     * 이때, ServletRequest, ServletResponse 객체가 전달된다.
     * - ServletRequest : 요청 관련 정보를 가진 객체
     *      - HttpServletRequest : 웹 요청에 관련된 추상체. 실제 생성 객체는 이 인터페이스를 구현
     * - ServletResponse : 응답 준비와 관련된 정보를 가진 객체
     *      - HttpServletResponse : 웹 응답에 관련된 추상체. 실제 생성 객체는 이 인터페이스를 구현
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#service(ServletRequest, ServletResponse)");

        //다운 캐스팅
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        // 전송 방식에 따른 분기 처리
        String method = httpReq.getMethod();
        switch (method) {
            case "GET" :
                doGet(httpReq, httpRes); break;
            case "POST" :
                doPost(httpReq, httpRes); break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#doGet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#doPost");
    }
}
