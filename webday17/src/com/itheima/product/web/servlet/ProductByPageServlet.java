package com.itheima.product.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.product.domain.PageBean;
import com.itheima.product.service.ProductService;

/**
 * Servlet implementation class ProductByPageServlet
 */
public class ProductByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String strCurrPage = request.getParameter("currPage");
			ProductService productService = new ProductService();
			PageBean pageBean = productService.findByPage(strCurrPage);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/jsp/productByPage_list.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
