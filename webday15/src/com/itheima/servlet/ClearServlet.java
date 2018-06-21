package com.itheima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.FindCookie;

/**
 * Servlet implementation class ClearServlet
 */
public class ClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie cookie = new Cookie("history", null);
		cookie.setPath("/webday15");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
//第二种写法
//		Cookie[] cookies = request.getCookies();
//		Cookie c = FindCookie.getCookie(cookies, "history");
//		
//		if (c != null && c.getValue() != null) {
//			c.setValue(null);
//		}
//		response.addCookie(c);


		//request.getRequestDispatcher("/WEB01/product_list.jsp").forward(request, response);
		response.sendRedirect("/webday15/WEB01/product_list.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
