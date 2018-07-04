package com.itheima.store.web.servlet;

import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.service.impl.ProductServiceImpl;
import com.itheima.store.utils.CookieUtil;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 根据商品分类进行查询，并且分页显示
	 * @param request
	 * @param response
	 * @return
	 */
	public String findByCid(HttpServletRequest request,HttpServletResponse response) {
		try {
			String cid = request.getParameter("cid");
			Integer currPage = Integer.parseInt(request.getParameter("currPage"));
			ProductService productService = new ProductServiceImpl();
			PageBean pageBean = productService.findByCid(cid,currPage);
			request.setAttribute("pageBean", pageBean);
			return "/store/product_list.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
	/**
	 * 点击商品，根据商品ID查询商品详情信息 
	 * @param request
	 * @param response
	 * @return
	 */
	public String findByPid(HttpServletRequest request,HttpServletResponse response) {
		try {
			String pid = request.getParameter("pid");		
			ProductService productService = new ProductServiceImpl();
			Product product = productService.findByPid(pid);
			
			//商品浏览记录 ,"history"
			Cookie[] cookies = request.getCookies();
			Cookie cookie = CookieUtil.getCookie(cookies, "history");
			LinkedList<String> linkedList ;
			if(cookie == null) {
				cookie = new Cookie("history",pid);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
				String[] ids = cookie.getValue().split("-");
				linkedList = new LinkedList<String>(Arrays.asList(ids));
			}else {
				
				String[] ids = cookie.getValue().split("-");
				linkedList = new LinkedList<String>(Arrays.asList(ids));
				linkedList.remove(pid);
				linkedList.addFirst(pid);
				if(linkedList.size() > 6) {
					linkedList.removeLast();
				}
				
				StringBuffer sb = new StringBuffer();
				for (String id : linkedList) {
					sb.append(id).append("-");
				}
				String substring = sb.toString().substring(0,sb.length()-1);
				cookie = new Cookie("history",substring);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(7*24*60*60);
				response.addCookie(cookie);
			}
			request.getSession().setAttribute("history", linkedList);
			
			request.setAttribute("product", product);
			return "/store/product_info.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
