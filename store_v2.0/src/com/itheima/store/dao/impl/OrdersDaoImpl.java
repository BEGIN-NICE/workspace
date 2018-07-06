package com.itheima.store.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.store.dao.OrdersDao;
import com.itheima.store.domain.Orders;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public void saveOrders(Connection conn, Orders orders) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
		Object[] params = {orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUid()};
		queryRunner.update(conn, sql, params);
		
	}

}
