package com.itheima.demo4_ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("getMethod.....name="+name+"   pass="+password);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-1");
		String name = request.getParameter("name");
		System.out.println(name);
		String password = request.getParameter("pass");
		System.out.println(password);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("postMethod.....name="+name+"   pass="+password);
	}

}
