package com.itheima.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.FindCookie;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		Integer count = (Integer)this.getServletContext().getAttribute("count");
		Cookie[] cookies = request.getCookies();
		//设置记录上次登录时间的cookie名为lastVisit
		Cookie cookie = FindCookie.getCookie(cookies, "lastVisit");
//		for (Cookie c : cookies) {
//			System.out.println(c.getName()+"===="+c.getValue());
//		}
		if (cookie == null) {
			response.getWriter().println("你是第"+count+"位来访用户");
		}else {
			String value = cookie.getValue();
			long l = Long.parseLong(value);
			Date date = new Date(l);
			response.getWriter().println(count+"欢迎来访，你的上次访问时间是："+date.toLocaleString());
		}
		
		Cookie cookie2 = new Cookie("lastVisit",""+System.currentTimeMillis());
		//设置cookie的有效路径
		cookie2.setPath("/webday15");
		//设置cookie的有效时间
		cookie2.setMaxAge(60*60);//一小时
		response.addCookie(cookie2);
		response.getWriter().print("<h2><a href='/webday15/WEB01/product_list.jsp'>商品列表</a></h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
