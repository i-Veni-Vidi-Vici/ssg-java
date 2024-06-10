package com.sh._11_filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Filter
 * - 서블릿 전처리/후처리가 가능한 웹스펙
 * - 여러서블릿에 공통적인 작업이 있는 경우 이 필터를 통해 관리할 수 있다.
 * - @WebFilter 어노테이션의 작성한 url에 매칭되는 Filter가 자동으로 호출된다.
 * 
 * 생명주기
 * 1.객체생성 : tomcat구동시 모든 filter객체를 생성한다.
 * 2. init : 객체생성후 바로호출. 요청 url가 매칭되는 필터를 최초1회 호출한다.
 * 3. doFilter : 실제 처리코드 
 *      - 여러 Filter를 FilterChain객체로 관리
 *      - FilterChain의 다음 Filter 호출
 *      - 마지막 Filter인 경우 Servlet으로 연결
 * 4. destroy : tomcat 작동을 중지시 호출
 * 
 */
//@WebFilter("/first/lifecycle")
@WebFilter("/first/*")
//@WebFilter(urlPatterns = {"/first/*", "/second/*"}) // value = urlPatterns
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 생성자 호출!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FirstFilter#init 메소드 호출!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 전처리부분 (요청 수신 직후) : 인코딩처리, 인증처리, 로깅처리 등
        System.out.println("FirstFilter#doFilter 메소드 호출! 전처리");
        
        // FilterChain의 다음 Filter 호출
        filterChain.doFilter(servletRequest, servletResponse);
        
        // 후처리부분 (응답 발송 직전) : 응답리소스 압축처리 등
        System.out.println("FirstFilter#doFilter 메소드 호출! 후처리");
        
        
    }

    @Override
    public void destroy() {
        System.out.println("FirstFilter#destroy 메소드 호출!");
    }
}
