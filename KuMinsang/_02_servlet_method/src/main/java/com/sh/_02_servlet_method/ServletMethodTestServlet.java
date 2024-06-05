package com.sh._02_servlet_method;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 어노테이션은 일반적으로 value 속성을 갖는다
 * annotation 속성 없이 인자 하나만 입력될 경우 자동으로 value에 바인딩 된다
 */
@WebServlet(name="ServletMethodTestServlet", value="/test")
public class ServletMethodTestServlet extends HttpServlet {
    /**
     *  매 요청마다 service 메소드가 호출된다.
     *  이 때, ServletRequest, ServletResponse객체가 전달된다
     *  - ServletRequest : 요청관련 정보를 가진 객체
     *      - HttpServletRequest : 웹 요청에 관련된 추상체
     *  - ServletResponse : 응갑 준비와 관련된 정보를 가진 객체
     *      - HttpServletResponse : 웹 응답에 관련된 추상체
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#service(ServletRequest, ServletResponse)");

        //다운캐스팅
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        //전송방식에 따른 분기 처리
        String method = httpReq.getMethod();
        switch(method){
            case "GET": doGet(httpReq, httpRes); break;
            case "POST": doPost(httpReq, httpRes); break;
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
