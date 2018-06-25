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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String username = request.getParameter("username");
			LoginService loginService = new LoginService();
			User user = new User();
			user.setUsername(username);
			User exsitUser = loginService.checkUser(user);
			response.setContentType("text/html;charset=utf-8");
			if(exsitUser!=null) {
				response.getWriter().println("<font color='red'>用户名已被占用</font>");
			}else {
				response.getWriter().println("<font color='green'>用户名可以使用</font>");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String password = request.getParameter("password");
			LoginService loginService = new LoginService();
			User user = new User();
			user.setPassword(password);
			User checkUserpassword = loginService.checkUserpassword(user);
			response.setContentType("text/html;charset=utf-8");
			if(checkUserpassword != null) {
				response.getWriter().println("0");
			}else {
				response.getWriter().println("1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
