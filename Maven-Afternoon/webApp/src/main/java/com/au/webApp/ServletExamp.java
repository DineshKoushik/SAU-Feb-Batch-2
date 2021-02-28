package com.au.webApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletExamp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletExamp() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
		response.getWriter().println("Hello World!");
		}
    
    @Override
    public void init() throws ServletException{
    	System.out.println("Servlet" + this.getServletName() + "has started!");
    }
    
    @Override
    public void destroy() {
    	System.out.println("Servlet" + this.getServletName() + "has stopped!");
    }
    
}
