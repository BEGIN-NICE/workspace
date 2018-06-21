package com.itheima.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.FindCookie;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		System.out.println(id);
		Cookie[] cookies = request.getCookies();
		//设置记录商品id的cookie的名为：history
		Cookie cookie = FindCookie.getCookie(cookies, "history");
		if(id!=null&& !("null".equals(id))) {
			if (cookie==null) {
				//第一次浏览商品
				Cookie c = new Cookie("history", id);
				c.setPath("/webday15");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
				
			}else {
				//不是第一次浏览
				String value = cookie.getValue();
				String[] split = value.split("-");
				LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
				if (list.contains(id)) {
					list.remove(id);
					list.addFirst(id);
				}else {
					if(list.size()<3) {
						list.addFirst(id);
					}else {
						list.removeLast();
						list.addFirst(id);
					}
				}
				StringBuffer sb = new StringBuffer();
				for (String string : list) {
					sb.append(string).append("-");
				}
				value = sb.toString().substring(0, sb.length()-1);
				System.out.println(value);
				Cookie c = new Cookie("history", value);
				c.setPath("/webday15");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			}
		}
	//	request.getRequestDispatcher("/WEB01/product_info.htm").forward(request, response);
	response.sendRedirect("/webday15/WEB01/product_info.htm");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
