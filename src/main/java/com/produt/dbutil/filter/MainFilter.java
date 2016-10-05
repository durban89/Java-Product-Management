package com.produt.dbutil.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by durban126 on 16/10/5.
 */
public class MainFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String path = httpServletRequest.getContextPath();
        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        if(username == null){
            httpServletResponse.sendRedirect(path+"/index.jsp");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    public void destroy() {

    }
}
