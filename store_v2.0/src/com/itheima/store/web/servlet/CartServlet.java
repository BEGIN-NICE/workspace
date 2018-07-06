package com.itheima.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Cart;
import com.itheima.store.domain.CartItem;
import com.itheima.store.domain.Product;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String addCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			String pid = request.getParameter("pid");
			int count = Integer.parseInt(request.getParameter("count"));
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			Product product = productService.findByPid(pid);
			CartItem cartItem = new CartItem();
			cartItem.setCount(count);
			cartItem.setProduct(product);
			Cart cart = (Cart) getCart(request);
			cart.addCart(cartItem);
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath()+"/store/cart.jsp");
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "服务器正在维护，请稍后再试！");
		return "/store/message.jsp";
	}

	//删除购物车的某个商品
	public String deleteCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			String pid = request.getParameter("pid");
			Cart cart = (Cart) getCart(request);
			cart.removeCart(pid);
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath()+"/store/cart.jsp");
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "服务器正在维护，请稍后再试！");
		return "/store/message.jsp";
	}
	
	//清空购物车
	public String clearCart(HttpServletRequest request,HttpServletResponse response) {
		try {
			Cart cart = (Cart) getCart(request);
			cart.clearCart();
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath()+"/store/cart.jsp");
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "服务器正在维护，请稍后再试！");
		return "/store/message.jsp";
	}

	
	
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

}
