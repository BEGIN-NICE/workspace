package com.itheima.store.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.store.dao.OrderItemDao;
import com.itheima.store.domain.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public void saveOrderItem(Connection conn, OrderItem orderItem) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orderitem values (?,?,?,?,?)";
		Object[] params = {orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getPid(),orderItem.getOid()};
		queryRunner.update(conn, sql, params);
		
	}

}
