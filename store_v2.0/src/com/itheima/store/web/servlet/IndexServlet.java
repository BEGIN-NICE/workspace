package com.itheima.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.service.impl.ProductServiceImpl;
import com.itheima.store.utils.BeanFactory;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1.转发到首页的的index方法
	 */
	public String index(HttpServletRequest req, HttpServletResponse resp) {		
		try {
			ProductService productService = (ProductServiceImpl) BeanFactory.getBean("productServiceImpl");
			//查询热门商品
			List<Product> listHot = productService.findByHot();
			
			//查询最新商品
			List<Product> listNew = productService.findByNew();
			req.getSession().setAttribute("listHot", listHot);
			req.getSession().setAttribute("listNew", listNew);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/store/index.jsp";
	}
}
