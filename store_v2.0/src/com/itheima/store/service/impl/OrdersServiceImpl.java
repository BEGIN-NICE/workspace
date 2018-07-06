package com.itheima.store.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.store.dao.OrderItemDao;
import com.itheima.store.dao.OrdersDao;
import com.itheima.store.domain.OrderItem;
import com.itheima.store.domain.Orders;
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

}
