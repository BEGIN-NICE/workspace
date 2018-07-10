package com.itheima.store.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Category;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.CategoryService;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;

/**
 * Servlet implementation class AdminProductServlet
 */
public class AdminProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String findAllByPage(HttpServletRequest request,HttpServletResponse response){
		try {
			String currPageStr = request.getParameter("currPage");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			PageBean pageBean = productService.findAllByPage(currPageStr);
			request.setAttribute("pageBean", pageBean);
			return "/admin/product/list.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String saveUI(HttpServletRequest request,HttpServletResponse response){
		try {
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
			return "/admin/product/add.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String save(HttpServletRequest request,HttpServletResponse response){
		try {
			String currPageStr = request.getParameter("currPage");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			PageBean pageBean = productService.findAllByPage(currPageStr);
			request.setAttribute("pageBean", pageBean);
			return "/admin/product/list.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String editUI(HttpServletRequest request,HttpServletResponse response){
		try {
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			Product product = productService.findByPid(pid);
			request.setAttribute("p", product);
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
			return "/admin/product/edit.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//об╪э
	public String pushDown(HttpServletRequest request,HttpServletResponse response){
		try {
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			productService.pushDown(pid);
			
			return "/AdminProductServlet?method=findAllByPage&currPage=1";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String findAllByPushDown(HttpServletRequest request,HttpServletResponse response){
		try {
			String currPageStr = request.getParameter("currPage");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			PageBean pageBean = productService.findAllByPushDown(currPageStr);
			request.setAttribute("pageBean", pageBean);
			return "/admin/product/pushdown_list.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//ио╪э
	public String pushUp(HttpServletRequest request,HttpServletResponse response){
		try {
			String pid = request.getParameter("pid");
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			Product product = productService.findByPid(pid);
			product.setPflag(0);
			productService.update(product);
			
			return "/AdminProductServlet?method=findAllByPushDown&currPage=1";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
