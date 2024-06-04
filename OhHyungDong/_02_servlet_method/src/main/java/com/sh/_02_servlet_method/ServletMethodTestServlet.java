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
 * a매 요청 마다 service 메소드가 호출된다
 * 이때 , ServletRequest, ServletResponse 객체가 전달된다.
 * - ServletRequest : 요청관련 정보를 가진 객체
 *  - HttpServletRequest : 웹 요청에 관련된 추상체
 * - ServletResponse : 응답 준비와 관련된 정보를 가진 객체
 *  - HttpServletResponse : 웹 응답에 관련된 추상체
 */

@WebServlet(name = "ServletMethodTestServlet",value = "/test")  //a만약 값하나만 속셩명이 존재한다면, value가 속성값이다.value = "/test")
public class ServletMethodTestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ServletMethodTestServlet#service(ServletRequest,ServletResponse");

        //다운 캐스팅
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;

        //전송방식에 따른 분기처리
        String method = httpReq.getMethod();
        switch (method){
            case "GET" : doGet(httpReq, httpRes); break;
            case "POST" : doPost(httpReq,httpRes); break;
        }
    }


}
