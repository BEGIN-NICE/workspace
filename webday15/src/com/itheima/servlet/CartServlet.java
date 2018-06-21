package com.itheima.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String name = new
		// String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String name = request.getParameter("name");
		System.out.println(name);
		Map<String, Integer> map = (Map) request.getSession().getAttribute("cart");
		if (map == null) {
			map = new HashMap<>();
		} else {
			if (!map.containsKey(name)) {
				map.put(name, 1);
			} else {
				Integer count = map.get(name);
				count++;
				map.put(name, count);
			}
		}
		request.getSession().setAttribute("cart", map);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(
				"<h2><a href='/webday15/WEB01/product_list.jsp'>继续购物</a> | <a href='/webday15/WEB01/count.jsp'>去结算</a></h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
