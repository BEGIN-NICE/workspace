package com.itheima.store.web.servlet;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.store.domain.Cart;
import com.itheima.store.domain.OrderItem;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.PayBean;
import com.itheima.store.domain.Product;
import com.itheima.store.domain.User;
import com.itheima.store.service.OrderItemService;
import com.itheima.store.service.OrdersService;
import com.itheima.store.service.ProductService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.PaymentUtil;
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
	
	/**
	 * 查询订单
	 */
	public String findByUid(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			if(user==null) {
				return "/store/login.jsp";
			}
			String currPageStr = request.getParameter("currPage");
			PageBean<Orders> pageBean = new PageBean<Orders>();
			int currPage;
			if(currPageStr==null) {
				currPage = 1;
			}else {
				currPage = Integer.parseInt(currPageStr);
			}
			pageBean.setCurrPage(currPage);
			
			int pageSize = 5;
			pageBean.setPageSize(pageSize);
			
			OrdersService orderService = (OrdersService) BeanFactory.getBean("ordersService");
			int count = orderService.findCountByUid(user.getUid());
			pageBean.setTotalCount(count);
			
			Double ceil = Math.ceil((double)count/pageSize);
			pageBean.setTotalPage(ceil.intValue());
			
			int begin = (currPage-1)*pageSize;
			List<Orders> list = orderService.findOrderByUid(user.getUid(),begin,pageSize);
			
			pageBean.setList(list);
			request.setAttribute("pageBean", pageBean);
					
			return "/store/order_list.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public String findByOid(HttpServletRequest request, HttpServletResponse response) {
		try {	
			String oid = request.getParameter("oid");
			OrdersService orderService = (OrdersService) BeanFactory.getBean("ordersService");
			Orders orders = orderService.findByOid(oid);
			request.setAttribute("orders", orders);
			return "/store/order_info.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	
	public String payOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			String oid = request.getParameter("p2_Order");
			Map<String, String[]> map = request.getParameterMap();
			PayBean payBean = new PayBean();
			BeanUtils.populate(payBean, map);
			
			OrdersService orderService = (OrdersService) BeanFactory.getBean("ordersService");
			Orders orders = orderService.findByOid(oid);
			orders.setName(request.getParameter("name"));
			orders.setAddress(request.getParameter("address"));
			orders.setTelephone(request.getParameter("telephone"));
			orderService.update(orders);
			request.setAttribute("payBean", payBean);
			
			return "/store/pay.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	public String callBack(HttpServletRequest request, HttpServletResponse response) {
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String  r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		
		try {
			String hmac = request.getParameter("hmac");
			boolean flag = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
			if(flag) {
				OrdersService orderService = (OrdersService) BeanFactory.getBean("ordersService");
				Orders orders = orderService.findByOid(r6_Order);
				orders.setState(2);
				orderService.update(orders);
			}
			
			return "/OrderServlet?method=findByUid";
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
