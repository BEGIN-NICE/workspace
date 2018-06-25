package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.LoginService;


/**
 * Servlet implementation class JqLoginServlet
 */
public class JqLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			System.out.println(username);
			User user = new User();
			user.setUsername(username);
			LoginService loginService = new LoginService();

			User checkUser = loginService.checkUser(user);
			if (checkUser != null) {
				response.getWriter().println("<font color='red'>用户名已被占用</font>");
			}else {
				response.getWriter().println("<font color='green'>用户名可以使用</font>");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			System.out.println(username);
			User user = new User();
			user.setUsername(username);
			LoginService loginService = new LoginService();

			User checkUser = loginService.checkUser(user);
			if (checkUser != null) {
				response.getWriter().println("1");
			}else {
				response.getWriter().println("0");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
