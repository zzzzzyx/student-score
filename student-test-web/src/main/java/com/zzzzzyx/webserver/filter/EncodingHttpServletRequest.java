package com.zzzzzyx.webserver.filter;

import java.io.UnsupportedEncodingException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletRequestWrapper;  
  
public class EncodingHttpServletRequest extends HttpServletRequestWrapper{  
  
    private HttpServletRequest request;  
    public EncodingHttpServletRequest(HttpServletRequest request) {  
        super(request);  
        this.request = request;  
    }  
    @Override  
    public String getParameter(String name) {  
        String value = request.getParameter(name);  
        try {  
            if(value!=null){  
//            	System.out.println("before filter: " + value);
                //tomcat默认编码文ISO8859-1  
                value = new String(value.getBytes("ISO8859-1"),"UTF-8");  
//                System.out.println("after filter: " + value);
            }  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return value;  
    }  
}  