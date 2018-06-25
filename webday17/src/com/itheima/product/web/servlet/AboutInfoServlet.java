package com.itheima.product.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.service.AboutInfoService;

/**
 * Servlet implementation class AboutInfoServlet
 */
public class AboutInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("utf-8");
		String info = request.getParameter("info");
		AboutInfoService aboutInfoService = new AboutInfoService();
		List<String> list = aboutInfoService.aboutInfo(info);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ajax/info_list.jsp").forward(request, response);
		
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
