package com.itheima.auto.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.auto.domain.User;
import com.itheima.auto.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<String, String[]> map = request.getParameterMap();
			User user = new User();
			BeanUtils.populate(user, map);
			LoginService loginService = new LoginService();
			User existUser = loginService.login(user);
			System.out.println(existUser);
			if(existUser == null) {
				//登录失败
				request.setAttribute("errormsg", "用户名或密码错误");
				request.getRequestDispatcher("/WEB01/login.jsp").forward(request, response);
			}else {
				//登录成功
				String autologin = request.getParameter("autologin");
				if("true".equalsIgnoreCase(autologin)) {
					Cookie cookie = new Cookie("existUser", existUser.getUsername()+"#"+existUser.getPassword());
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60*60*24*7);
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("existUser", existUser);
				response.sendRedirect(request.getContextPath()+"/WEB01/index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.setCharacterEncoding("text/html;charset=utf-8");
			response.getWriter().println("服务器错误");
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
