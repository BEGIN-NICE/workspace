package com.itheima.store.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.store.dao.OrderItemDao;
import com.itheima.store.dao.OrdersDao;
import com.itheima.store.dao.ProductDao;
import com.itheima.store.domain.OrderItem;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.PageBean;
import com.itheima.store.service.OrdersService;
import com.itheima.store.utils.BeanFactory;
import com.itheima.store.utils.c3p0Util;

public class OrdersServiceImpl implements OrdersService {

	@Override
	public void saveOrder(Orders orders) {
		Connection conn = null;
		try {
			conn = c3p0Util.getConnection();
			conn.setAutoCommit(false);
			OrdersDao ordersDao = (OrdersDao) BeanFactory.getBean("ordersDao");
			OrderItemDao orderItemDao = (OrderItemDao) BeanFactory.getBean("orderItemDao");
			ordersDao.saveOrders(conn, orders);
			List<OrderItem> list = orders.getList();
			for (OrderItem orderItem : list) {
				orderItemDao.saveOrderItem(conn, orderItem);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		}

	}

	@Override
	public int findCountByUid(String uid) throws SQLException {
		OrdersDao orderDao=(OrdersDao) BeanFactory.getBean("ordersDao");
		return orderDao.findCountByUid(uid);
	}

	@Override
	public List<Orders> findOrderByUid(String uid, int begin, int pageSize) throws Exception{
		OrdersDao orderDao=(OrdersDao) BeanFactory.getBean("ordersDao");
		return orderDao.findOrderByUid(uid,begin,pageSize);
	}

	@Override
	public Orders findByOid(String oid) throws Exception {
		OrdersDao orderDao=(OrdersDao) BeanFactory.getBean("ordersDao");
		return orderDao.findByOid(oid);
	}

	@Override
	public void update(Orders orders) throws Exception {
		OrdersDao orderDao=(OrdersDao) BeanFactory.getBean("ordersDao");
		orderDao.update(orders);
	}

//	@Override
//	public PageBean findAllByPage(String currPageStr) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public PageBean findAllOrderByPage(String currPageStr) throws Exception {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		
		Integer currPage;
		if(currPageStr==null) {
			currPage=1;
		}else {
			currPage = Integer.parseInt(currPageStr);
		}
		pageBean.setCurrPage(currPage);
		
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		
		int begin = (currPage-1)*pageSize;
		OrdersDao orderDao=(OrdersDao) BeanFactory.getBean("ordersDao");
		int totalCount = orderDao.getCountOfOrders();
		pageBean.setTotalCount(totalCount);
		
		List<Orders> list = orderDao.findAllOrderByPage(begin,pageSize);
		pageBean.setList(list);
		
		Double totalPage = Math.ceil((double)totalCount/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		return pageBean;
	}


}
