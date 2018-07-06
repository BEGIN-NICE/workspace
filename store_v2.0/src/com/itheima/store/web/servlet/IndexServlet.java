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
	 * 1.ת������ҳ�ĵ�index����
	 */
	public String index(HttpServletRequest req, HttpServletResponse resp) {		
		try {
			ProductService productService = (ProductServiceImpl) BeanFactory.getBean("productServiceImpl");
			//��ѯ������Ʒ
			List<Product> listHot = productService.findByHot();
			
			//��ѯ������Ʒ
			List<Product> listNew = productService.findByNew();
			req.getSession().setAttribute("listHot", listHot);
			req.getSession().setAttribute("listNew", listNew);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/store/index.jsp";
	}
}
