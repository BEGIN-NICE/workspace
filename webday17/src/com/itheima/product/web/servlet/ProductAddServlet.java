package com.itheima.product.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.product.domain.Product;
import com.itheima.product.service.ProductAddService;
import com.itheima.utils.UUIDUtil;

/**
 * Servlet implementation class ProductAddServlet
 */
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String token = request.getParameter("token");
			Object token2 = request.getSession().getAttribute("token");
			request.getSession().removeAttribute("token");
			if(token==null || token2==null || !token.equals(token2)) {
				request.setAttribute("msg", "数据已经提交，请不要重复提交数据！！！");
				request.getRequestDispatcher("/jsp/token.jsp").forward(request, response);;
				return;
			}
			
			Map<String, String[]> map = request.getParameterMap();
			Product product = new Product();
			BeanUtils.populate(product, map);
			product.setPid(UUIDUtil.getUUID());
			product.setPdate(new Date());
			ProductAddService productAddService = new ProductAddService();
			int count = productAddService.addProduct(product);
			
			if(count != 0) {
//				response.sendRedirect(request.getContextPath()+"/ProductServlet");
				request.getRequestDispatcher("/ProductServlet").forward(request, response);
			}else {
				response.getWriter().println("something is error !!!");
			}
			
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
