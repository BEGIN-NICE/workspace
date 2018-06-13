package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.pojo.User;
import com.itheima.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		int count=0;
		this.getServletContext().setAttribute("count", count);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//封装到实体对象中
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//调用业务层处理数据
		UserService userService = new UserService();
		User u = userService.login(user);
		
		//解决向页面输出中文的乱码问题。
//		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=UTF-8");
		//根据返回结果显示信息
		if(u != null) {
			//跳转首页
//			response.getWriter().println("<h1>恭喜："+username+"   登录成功</h1>");
//			response.getWriter().println("<h1>页面将在5秒后跳转</h1>");
//			response.setHeader("Refresh", "5;url=/webday13/WEB01/index.html");
			
			//通过jsp完成跳转，并且时间动态显示
			response.setStatus(302);
			response.setHeader("Location", "/webday13/demo02-login/success.html");
			
			//记录地多少位用户登录成功
//			response.getWriter().println("<h1>恭喜："+username+"   登录成功</h1>");
//			response.getWriter().println("<h1>页面将在3秒后跳转</h1>");
//			response.setHeader("Refresh", "3;url=/webday13/CountServlet");
			
		}else {
			response.getWriter().print("<h1>登录失败,用户名或密码不存在</h1>");
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
