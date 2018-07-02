package com.itheima.load.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.load.domain.User;
import com.itheima.load.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserService userService = new UserService();
			User checkUser = userService.login(user);
			if(checkUser != null) {
				String autologin = request.getParameter("autologin");
				if("true".equals(autologin)) {
					Cookie cookie = new Cookie("user", checkUser.getUsername()+"#"+checkUser.getPassword());
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("user", checkUser);
				request.getRequestDispatcher("/first.jsp").forward(request, response);
			}else {
				request.setAttribute("login_error", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
