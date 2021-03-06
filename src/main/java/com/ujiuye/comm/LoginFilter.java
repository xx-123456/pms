package com.ujiuye.comm;

import com.ujiuye.sys.bean.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1=(HttpServletRequest)request;
        String requestURI = request1.getRequestURI();

        HttpServletResponse response1=(HttpServletResponse)response;
        Employee employee=(Employee)request1.getSession().getAttribute("loginUser");
        if (employee !=null || requestURI.contains("login") || requestURI.contains("images")){
            chain.doFilter(request,response);
        }else {
            response1.sendRedirect(request1.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
