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
			
			response.getWriter().println("����ʽ��"+method);
			response.getWriter().println("uri·����"+requestURI);
			response.getWriter().println("url·����"+requestURL);
			response.getWriter().println("localAddr��"+localAddr);
			response.getWriter().println("������ַ��"+remoteAddr);
			response.getWriter().println("��������"+remoteHost);
			response.getWriter().println("��������"+contextPath);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
