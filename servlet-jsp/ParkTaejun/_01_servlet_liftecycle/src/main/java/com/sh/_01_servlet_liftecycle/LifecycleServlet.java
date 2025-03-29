package com.sh._01_servlet_liftecycle;
// java ee -> jakarta ee
// javax.* -> jakarta.* 패키지구조로 벼녁ㅇ

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
 * - HttpServlet (웹 요청을 처리하는데 필요한 설정을 가진 클래스)
 * -> 상속해서 커스텀 서블릿을 생성할 수 있다.
 * -HttpServlet 상속구조
 *      - Servlet interface
 *          -GenericServlet class
 *              - HttpServlet class (웹 http 요청 처리용 클래스)
 *                  - CustomServlet
 * - Tomact은 요청별로 Servlet 객체를 관리한다 (Servlet /JSP Container)
 * - Tomcat은 Servlet 객체를 Singleton 패턴으로 관리한다 처음요청 왔을 때 그 객체로 재사용 한다.
 * - url별 첫 번째 요청에 Tomcat은 Servlet 객체를 생성하고, init(ServletConfig) 메소드를 호출한다
 * - 실제 요청을 처리한는 것은 service 메소드 들이다
 *      1. 요청이 오면, service(ServletReqest , ServletResponse)가 호출된다
 *      2. 전송방식별로 그에 상응하는 메소드 호출 doGet, doPost 등이 있따
 *- Tomcat 종료시에 모든 Servlet 객체를 destroy 메소드 호출 후  반환한다.
 *
 *
 */
// 가장 먼저 HttpServlet 의존 만들어 줘야함

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성자호출");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifecycleServlet#init 호출!");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("LifecycleServlet#service 호출 !");
    }

    @Override
    public void destroy() {
        System.out.println("LifecycleServlet#desroy 호출! ");
    }
}
