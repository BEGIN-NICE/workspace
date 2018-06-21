package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.User;
import com.itheima.sevice.UserLoginService;


/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求参数
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//封装到实体对象中
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				//调用业务层处理数据
				UserLoginService userLoginService = new UserLoginService();
				User u = userLoginService.login(user);
				
				//解决向页面输出中文的乱码问题。
//				response.setCharacterEncoding("GBK");
				response.setContentType("text/html;charset=UTF-8");
				//根据返回结果显示信息
				if(u != null) {
					response.sendRedirect("/webday14/WEB01/success.html");
					
					//记录地多少位用户登录成功
//					response.getWriter().println("<h1>恭喜："+username+"   登录成功</h1>");
//					response.getWriter().println("<h1>页面将在3秒后跳转</h1>");
//					response.setHeader("Refresh", "3;url=/webday13/CountServlet");
					
				}else {
					response.getWriter().print("<h1>登录失败,用户名或密码不存在</h1>");
				}
				
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
