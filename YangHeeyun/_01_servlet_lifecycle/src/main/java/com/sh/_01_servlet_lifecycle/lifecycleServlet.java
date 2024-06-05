package com.sh._01_servlet_lifecycle;

// java ee -> jakarta ee로 버전업
// javax.* -> jakarta.* 패키지구조로 변경

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/**
 * Servlet
 * - Serve + Applet(작은 Application)
 * - HTTP 요청을 처리할 수 있는 자바클래스
 *
 * - HttpServlet (웹욫어을 처리하는데 필요한 설정을 가진 클래스)
 * 상속해서 커스텀 서블릿을 생성할 수 있다.
 * - HttpServlet 상속구조
 *      - Servlet interface
 *          - GenericServlet class
 *              - HttpServlet class (웹 http요청 처리용 클래스)
 *                  - CustomServlet
 *
 * Tomcat은 요청별로 Servlet 객체를 관리한다. (Servlet/JSP container)
 * Tomcat은 Servlet객체를 Singletone패턴(단일객체)으로 관리한다.
 *      - 같은 요청에 대해 하나의 객체만 만들어서 공유하는 것
 * url별 첫번째 요청에 Tomcat은 Servlet객체를 생성하고, init(ServletConfig)메소드 호출
 * 실제 요청을 처리하는 것은 service메소드 들이다
 *      1. 요청이 오면, service(ServletRequest, ServletResponse)가 호출된다
 *      2. 전송방식별로 그에 상응하는 메소드 호출 doGet, doPost 등이 있다
 * Tomcat 종료시에 모든 Servket객체를 destory메소드 호출 후 반환한다.
 *
 */
@WebServlet("/lifecycle")
public class lifecycleServlet extends HttpServlet {
    public lifecycleServlet() {
        System.out.println("LifecycleServlet 생성자 호출!");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifecycleServlet#init 호출!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("LifecycleServlet#service 호출!");
    }

    public void destory(){
        System.out.println("LifecycleServlet#destory 호출!");
    }
}
