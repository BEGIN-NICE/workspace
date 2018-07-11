package com.itheima.store.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.Orders;

public interface OrdersDao {

	void saveOrders(Connection conn, Orders orders) throws SQLException;

	int findCountByUid(String uid) throws SQLException;

	List<Orders> findOrderByUid(String uid, int begin, int pageSize) throws Exception;

	Orders findByOid(String oid) throws Exception;

	void update(Orders orders)throws Exception;

	int getCountOfOrders() throws Exception;

	List<Orders> findAllOrderByPage(int begin, int pageSize) throws Exception;

	List<Orders> findAllOrderByPage(int begin, int pageSize, int parseInt) throws Exception;

	int getCountOfOrders(int parseInt)throws Exception;

}
