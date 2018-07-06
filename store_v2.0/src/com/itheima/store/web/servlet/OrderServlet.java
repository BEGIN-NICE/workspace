package com.itheima.store.web.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Cart;
import com.itheima.store.domain.OrderItem;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.Product;
import com.itheima.store.domain.User;
import com.itheima.store.service.OrderItemService;
import com.itheima.store.service.OrdersService;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.UUIDUtil;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 生成订单
	 */
	public String saveOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			User user = (User) request.getSession().getAttribute("user");
			if (cart == null) {
				return "/store/order_info.jsp";
			} else if (cart.getTotal() == 0d) {
				return "/store/cart.jsp";
			} else if (user == null) {
				request.setAttribute("msg", "请登陆！");
				return "/store/login.jsp";
			}
			// 封装订单
			OrdersService ordersService = (OrdersService) BeanFactory.getBean("ordersService");
			Orders orders = new Orders();
			orders.setUid(user.getUid());
			orders.setOid(UUIDUtil.getUUID());
			orders.setOrdertime(new Date());
			orders.setState(1);
			orders.setTotal(cart.getTotal());

			List<OrderItem> list = orders.getList();
			ProductService productService = (ProductService) BeanFactory.getBean("productServiceImpl");
			// 封装订单项
			for (String pid : cart.getMap().keySet()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setItemid(UUIDUtil.getUUID());
				orderItem.setOid(orders.getOid());
				orderItem.setPid(pid);
				// Product product = productService.findByPid(pid);
				// orderItem.setProduct(product);
				orderItem.setProduct(cart.getMap().get(pid).getProduct());

				orderItem.setCount(cart.getMap().get(pid).getCount());
				orderItem.setSubtotal(cart.getMap().get(pid).getSubTotal());
				list.add(orderItem);
			}
			ordersService.saveOrder(orders);
			cart.clearCart();
			request.getSession().setAttribute("orders", orders);
			response.sendRedirect(request.getContextPath() + "/store/order_info.jsp");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
