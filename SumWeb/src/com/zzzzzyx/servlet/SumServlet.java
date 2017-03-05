package com.zzzzzyx.servlet;
 
import java.io.IOException;
 
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.zzzzzyx.ejb.SumTool;
 
@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
      private static final long serialVersionUID = 1L;
      @EJB
      private SumTool sumtool;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
      /**
       * @seeHttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
       */
      protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            String param1 = request.getParameter("param1");
            String param2 = request.getParameter("param2");
            float f1 = Float.parseFloat(param1);
            float f2 = Float.parseFloat(param2);
            float result = sumtool.add(f1, f2);
            Number b = new Number();
            b.setParam1(f1);
            b.setParam2(f2);
            b.setResult(result);
            request.setAttribute("number", b);
            RequestDispatcher dispatcher =request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);
      }
 
      /**
       * @seeHttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
       */
      protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
      }
 
}