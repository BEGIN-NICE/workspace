package com.itheima.store.web.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Category;
import com.itheima.store.service.CategoryService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.UUIDUtil;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

/**
 * Servlet implementation class AdminCategoryServlet
 */
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			List<Category> list = categoryService.findAll();
			request.setAttribute("list", list);
			return "/admin/category/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String saveUI(HttpServletRequest request, HttpServletResponse response) {

		return "/admin/category/add.jsp";
	}

	public String save(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cname = request.getParameter("cname");
			Category category = new Category();
			category.setCid(UUIDUtil.getUUID());
			category.setCname(cname);
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			categoryService.save(category);
			//¹ýÂËÆ÷ÒÑ¾­ÅäÖÃ
		/*	CacheManager cacheManager = CacheManager
					.create(AdminCategoryServlet.class.getClassLoader().getResourceAsStream("ehcache.xml"));
			Ehcache ehcache = cacheManager.getEhcache("categoryCache");
			ehcache.remove("list");*/
			return "/AdminCategoryServlet?method=findAll";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public String edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cid = request.getParameter("cid");
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			Category category = categoryService.findByCid(cid);
			request.setAttribute("category", category);
			return "/admin/category/edit.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cid = request.getParameter("cid");
			String cname = request.getParameter("cname");
			Category category = new Category();
			category.setCid(cid);
			category.setCname(cname);
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			categoryService.update(category);
			return "/AdminCategoryServlet?method=findAll";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cid = request.getParameter("cid");
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			categoryService.deleteByCid(cid);
			return "/AdminCategoryServlet?method=findAll";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String checkCname(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cname = request.getParameter("cname");
			CategoryService categoryService = (CategoryService) BeanFactory.getBean("categoryServiceImpl");
			Category category = categoryService.findByCname(cname);
			if(category==null) {
				response.getWriter().println(1);
			}else {
				response.getWriter().println(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
