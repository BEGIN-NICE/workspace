package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.User;
import com.itheima.sevice.UserLoginService;

/**
 * Servlet implementation class UerLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sessionCode = (String)request.getSession().getAttribute("code");
		request.getSession().removeAttribute("code");
		String code = request.getParameter("code");
		if(!sessionCode.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/WEB01/login.jsp").forward(request, response);
	
		}else {
		
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
					
					Integer count = (Integer)this.getServletContext().getAttribute("count");
					this.getServletContext().setAttribute("count", count+1);
					response.sendRedirect("/webday15/WEB01/success.html");
					
					request.getSession().setAttribute("existUser", u);
					
				}else {
					request.setAttribute("mg", "用户名或密码错误");
					request.getRequestDispatcher("/WEB01/login.jsp").forward(request, response);
				}
		}	
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
