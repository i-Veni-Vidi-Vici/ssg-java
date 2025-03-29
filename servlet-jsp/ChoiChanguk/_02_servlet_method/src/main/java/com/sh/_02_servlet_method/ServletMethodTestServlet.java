package com.sh._02_servlet_method;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/test") // 기본이 value이고 생략이 가능하다, 다른 건 생략 불가
// 만약 값하나만 속성명 없이 존재 한다면, 그럼 value속성이다.
public class ServletMethodTestServlet extends HttpServlet {

    /***
     * 매 요청마다 service메소드가 호출된다
     * 이때, ServletRequest, ServletResponse
     * - ServletRequest : 요청관련 정보를 가진 객체
     *  - HttpServletRequest
     * - ServletResponse : 응답 준비와 관련된 정보를 가진 객체 실제 생성 객체는 이 인터페이스를 구현
     *  - HttpServletResponse :웹응답에 관련된 추상체
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#service(ServletRequest req, ServletResponse res)");

        // 다운캐이스팅
        HttpServletRequest httpReq=(HttpServletRequest) req;
        HttpServletResponse httpRes=(HttpServletResponse) res;

        // 전송방식에 따른 분기처리
        String method=httpReq.getMethod();
        switch (method)
        {
            case "GET" : doGet(httpReq,httpRes);
            break;
            case "POST" : doPost(httpReq,httpRes);
            break;
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