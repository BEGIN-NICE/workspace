package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMatorMessageServlet
 */
public class GetMatorMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String method = request.getMethod();
			String requestURI = request.getRequestURI();
			String requestURL = request.getRequestURL().toString();
			String localAddr = request.getLocalAddr();
			String remoteAddr = request.getRemoteAddr();
			String remoteHost = request.getRemoteHost();
			String contextPath = request.getContextPath();
			response.setContentType("text/html;charset=utf-8");
			
			response.getWriter().println("请求方式："+method);
			response.getWriter().println("uri路径："+requestURI);
			response.getWriter().println("url路径："+requestURL);
			response.getWriter().println("localAddr："+localAddr);
			response.getWriter().println("主机地址："+remoteAddr);
			response.getWriter().println("主机名："+remoteHost);
			response.getWriter().println("工程名："+contextPath);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
