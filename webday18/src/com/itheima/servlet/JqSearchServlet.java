package com.itheima.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.itheima.domain.Word;
import com.itheima.service.SearchService;

/**
 * Servlet implementation class JqSearchServlet
 */
public class JqSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			request.setCharacterEncoding("utf-8");
			String info = request.getParameter("search");
			SearchService searchService = new SearchService();
			List<Word> list = searchService.search(info);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/ajax_word/info.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
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
