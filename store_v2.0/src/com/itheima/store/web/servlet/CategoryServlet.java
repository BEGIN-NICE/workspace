package com.itheima.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Category;
import com.itheima.store.service.CategoryService;
import com.itheima.store.service.impl.CategoryServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Category
 */
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品分类
	 * @throws SQLException 
	 */
	public String findAll(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			CategoryService categoryService = new CategoryServiceImpl();
			List<Category> list = categoryService.findAll();
			JSONArray fromArray = JSONArray.fromObject(list);
			String string = fromArray.toString();
			response.getWriter().println(string);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
