package com.itheima.store.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.store.dao.OrdersDao;
import com.itheima.store.domain.OrderItem;
import com.itheima.store.domain.Orders;
import com.itheima.store.domain.Product;
import com.itheima.store.utils.c3p0Util;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public void saveOrders(Connection conn, Orders orders) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
		Object[] params = {orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUid()};
		queryRunner.update(conn, sql, params);
		
	}

	@Override
	public int findCountByUid(String uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from orders where uid = ?";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler(),uid);
		return l.intValue();
	}

	@Override
	public List<Orders> findOrderByUid(String uid, int begin, int pageSize) throws Exception{
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from orders where uid = ? order by ordertime desc limit ? ,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), uid,begin,pageSize);
		for (Orders order : list) {
			sql = "select * from product p,orderitem o where p.pid = o.pid and o.oid = ?";
			List<Map<String, Object>> itemList = queryRunner.query(sql, new MapListHandler(),order.getOid());
			for (Map<String, Object> map : itemList) {
				Product product = new Product();
				BeanUtils.populate(product, map);
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				orderItem.setProduct(product);
				order.getList().add(orderItem);
			}
		}
		return list;
	}

	@Override
	public Orders findByOid(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from orders where oid = ? ";
		Orders orders = queryRunner.query(sql, new BeanHandler<Orders>(Orders.class), oid);
		sql = "select * from product p,orderitem o where p.pid = o.pid and o.oid = ?";
		List<Map<String, Object>> map = queryRunner.query(sql, new MapListHandler(), orders.getOid());
		for (Map<String, Object> map2 : map) {
			Product product = new Product();
			BeanUtils.populate(product, map2);
			OrderItem orderItem = new OrderItem();
			BeanUtils.populate(orderItem, map2);
			orderItem.setProduct(product);
			orders.getList().add(orderItem);
		}
		
		return orders;
	}

	@Override
	public void update(Orders orders) throws Exception {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "update orders set ordertime=?,total=?,state=?,address=?,name=?,telephone=?,uid=? where oid=? ";
		Object[] params= {orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUid(),orders.getOid()};
		queryRunner.update(sql, params);
	}

	@Override
	public int getCountOfOrders() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from orders";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler());
		return l.intValue();
	}

	@Override
	public List<Orders> findAllOrderByPage(int begin, int pageSize) throws Exception {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from orders order by ordertime desc limit ? ,?";
		List<Orders> list = queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class), begin,pageSize);
		for (Orders order : list) {
			sql = "select * from product p,orderitem o where p.pid = o.pid and o.oid = ?";
			List<Map<String, Object>> itemList = queryRunner.query(sql, new MapListHandler(),order.getOid());
			for (Map<String, Object> map : itemList) {
				Product product = new Product();
				BeanUtils.populate(product, map);
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				orderItem.setProduct(product);
				order.getList().add(orderItem);
			}
		}
		return list;
	}
}
