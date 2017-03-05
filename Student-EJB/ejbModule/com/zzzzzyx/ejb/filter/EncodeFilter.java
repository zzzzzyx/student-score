package com.zzzzzyx.ejb.filter;

import java.io.IOException;

import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  

public class EncodeFilter implements Filter  {

	public void destroy() {  
          
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest req = (HttpServletRequest) request;  
        EncodingHttpServletRequest wraper = new EncodingHttpServletRequest(req);  
        chain.doFilter(wraper, response);  
    }  
  

    public void init(FilterConfig filterConfig) throws ServletException {  
          
    }  

}