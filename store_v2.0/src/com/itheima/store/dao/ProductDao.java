package com.itheima.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.Orders;
import com.itheima.store.domain.Product;

public interface ProductDao {

	List<Product> findByHot() throws SQLException;

	List<Product> findByNew() throws SQLException;

	List<Product> findByCid(String cid, Integer pageSize, Integer currPage) throws SQLException;

	Integer findCountByCid(String cid) throws SQLException;

	Product findByPid(String pid) throws SQLException;

	int getCount() throws SQLException;

	List<Product> findAllByPage(int begin, int pageSize) throws SQLException;

	void save(Product product) throws SQLException;

	void pushDown(String pid) throws SQLException;

	List<Product> findAllByPushDown(int begin, int pageSize) throws SQLException;

	void update(Product product) throws SQLException;

	int getCountPushDown() throws SQLException;



}
