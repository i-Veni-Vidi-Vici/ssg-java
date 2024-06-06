package com.sh._01_servlet_lifecycle;

// java ee -> jakarta ee
// javax.* -> jakarta.* 패키지 구조로 변경

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/**
 * Servlet
 * - = Server + Applet ( 작은 어플리케이션)
 * - HTTP 요청을 처리할 수 있는 자바 클래스
 *
 * - HTTPServlet (웹 요청을 처리한느데 필요한 설정을 가진 클래스) 상속해서 커스텀 서블릿을 생성할 수 있다.
 * - HTTPServlet의 상속 구조
 *     - Servlet interface
 *         - GenericServlet class → 구현체
 *             - HTTPServlet class( 웹 http 요청 처리용 클래스)
 *                 - CustomServlet
 * - Tomcat은 요청별로 Servlet 객체를 관리함(Servlet/JSP Contationer)
 *     - 객체 생성/ 삭제도 톰캣이 다 알아서 함
 * - Tomcat은 Servlet객체를 Singletone(단일 객체 → 하나만 만들어서 재사용함) 패턴으로 관리함 ⇒ 같은 요청을 할 경우, 하나를 재사용하는 것이 가장 효율적이기 때문
 * - url별 첫번째 요청에 Tomcat은 Servelt객체를 생성하고, init(ServletConfig)메소드 호출
 * - 실제 요청을 처리하는 것은 service 메소드들이다.
 *     1. 요청이 오면, service(ServletRequest, ServletResponse)가 호출된다.
 *     2. 전송방식 별로, 그에 상응하는 메소드를 호출 doGet, dePost 등이 있다.
 * - Tomcat 종료 시에 모든 Servlet 객체를 destroy 메소드 호출 후, 반환함

 */

@WebServlet("/lifecycle") //  / 꼭 써줘야 함!!
public class LifecycleServlet extends HttpServlet {
    public LifecycleServlet() {
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

    @Override
    public void destroy() {
        System.out.println("LifecycleServlet#destroy 호출!");
    }
}
