package com.itheima.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.store.domain.Orders;
import com.itheima.store.domain.PageBean;
import com.itheima.store.service.OrdersService;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;

/**
 * Servlet implementation class AdminOrderServlet
 */
public class AdminOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String findAllByPage(HttpServletRequest request,HttpServletResponse response){
		try {
			String currPageStr = request.getParameter("currPage");
			String state = request.getParameter("state");
			OrdersService ordersService = (OrdersService) BeanFactory.getBean("ordersService");
			PageBean pageBean = ordersService.findAllOrderByPage(currPageStr,state);
			request.setAttribute("pageBean", pageBean);
			return "/admin/order/list.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public String detail(HttpServletRequest request,HttpServletResponse response){
		try {
			String oid = request.getParameter("oid");
			OrdersService ordersService = (OrdersService) BeanFactory.getBean("ordersService");
			Orders orders = ordersService.findByOid(oid);
			request.setAttribute("orders", orders);
			return "/admin/order/detail.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String updateState(HttpServletRequest request,HttpServletResponse response){
		try {
			String oid = request.getParameter("oid");
			OrdersService ordersService = (OrdersService) BeanFactory.getBean("ordersService");
			Orders orders = ordersService.findByOid(oid);
			orders.setState(3);
			ordersService.update(orders);
			request.setAttribute("orders", orders);
			return "/AdminOrderServlet?method=findAllByPage";
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
