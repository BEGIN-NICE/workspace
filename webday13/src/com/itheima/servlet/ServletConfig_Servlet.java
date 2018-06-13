package com.itheima.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextConfigServlet
 */
public class ServletConfig_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ²âÊÔContextConfigµÄ·½·¨
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		String servletName = servletConfig.getServletName();
		System.out.println("servletName --- "+servletName);
		String initParameter = servletConfig.getInitParameter("username");
		System.out.println("initParameter   ---   "+initParameter);
		Enumeration<String> en = servletConfig.getInitParameterNames();
		while (en.hasMoreElements()) {
			String string = (String) en.nextElement();
			String value = servletConfig.getInitParameter(string);
			System.out.println(string+"  ---  "+value);
			
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
