package com.itheima.store.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.Orders;
import com.itheima.store.domain.PageBean;

public interface OrdersService {

	void saveOrder(Orders orders);

	int findCountByUid(String uid) throws SQLException;

	List<Orders> findOrderByUid(String uid, int begin, int pageSize) throws SQLException, Exception;

	Orders findByOid(String oid) throws Exception;

	void update(Orders orders)throws Exception;

//	PageBean findAllByPage(String currPageStr);

	PageBean findAllOrderByPage(String currPageStr) throws Exception;


}
