package com.itheima.store.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.store.domain.OrderItem;

public interface OrderItemDao {

	void saveOrderItem(Connection conn, OrderItem orderItem) throws SQLException;

}
