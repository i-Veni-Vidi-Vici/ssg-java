package com.sh.authapp.common;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter("/member/membersOnly/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.debug("Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if(session.getAttribute("member") == null){
            response.sendRedirect(request.getContextPath() + "/");
            log.debug("인증 되지 않은 사용자의 접근");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
            log.debug("member = {}", session.getAttribute("member"));
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
