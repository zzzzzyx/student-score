package com.zzzzzyx.ejb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter  {

	public void destroy() {  
          
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest req = (HttpServletRequest) request;  
        HttpSession session = req.getSession(false);
        Boolean login = (Boolean) session.getAttribute("login");
        if(login == null || login == false){
        	 response.setContentType("text/html;charset=utf-8");
        	 ((HttpServletResponse) response).sendRedirect("login");
        }else{
        	chain.doFilter(request, response);  
        }
        
    }  
  

    public void init(FilterConfig filterConfig) throws ServletException {  
          
    }  

}
