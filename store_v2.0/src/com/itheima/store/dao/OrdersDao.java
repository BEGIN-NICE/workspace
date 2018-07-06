package com.itheima.store.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.store.domain.Orders;

public interface OrdersDao {

	void saveOrders(Connection conn, Orders orders) throws SQLException;

}
