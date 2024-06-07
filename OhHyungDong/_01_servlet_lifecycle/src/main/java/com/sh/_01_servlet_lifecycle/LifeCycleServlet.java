package com.sh._01_servlet_lifecycle;
//java ee  -> jakarta ee
// java.x -> jakarta.* 패키지 구조로 변경
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


/**
 * Servlet
 * - Serve + Applet(Application)
 * - HTTP 요청을 처리할 수 있는 자바 클래스
 *
 * - HttpServlet (웹 요청을 처리하는데 필요한 설정을 가진 클래스) 상속해서 Custom Servlet 생성
 * - HttpServlet 상속 구조
 *      - Servlet interface
 *          - GenericServlet(구현체)
 *              - HttpServlet class (웹 http 요청 처리용 클래스)
 *                  - CustomServlet c
 *
 * Tomcat은 요청별로 Servlet 객체를 관리한다. (Servlet / JSP Container)
 * Tomcat은 Servlet객체를 Singleton패턴으로 관리한다.
 * url별 첫번째 요청에 Tomcat은 Servlet객체를 생성하고, init(ServletConfig) 메소드를 호출한다.
 * 실제 요청을 처리하는 것은 service 메소드들이다.
 *  1. 요청이오면 service(ServletRequest, ServletResonse)가 호출된다.
 *  2. 전송방식별로 그에 상응하는 메소드 호출(doGet, doPost)
 * Tomcat 종료시에 모든 Servle 객체를 반환한다. -> destory메소드 호출후 반환
 */
@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet 생성자 호출 ");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycleServlet#init 호출");
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException{
        System.out.println("LifeCycleServlet#service 호출");
    }

    @Override
    public void destroy(){

        System.out.println("LifecycleServlet#destroy 호출 ");
    }
}
