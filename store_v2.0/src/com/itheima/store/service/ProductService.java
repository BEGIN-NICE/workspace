package com.itheima.store.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.PageBean;
import com.itheima.store.domain.Product;

public interface ProductService {

	List<Product> findByHot() throws SQLException;

	List<Product> findByNew() throws SQLException;

	PageBean findByCid(String cid, Integer currPage) throws SQLException;

	Product findByPid(String pid) throws SQLException;

	int getCount()throws SQLException;

	PageBean findAllByPage(String currPageStr) throws SQLException;

	void save(Product product)throws SQLException;

	void pushDown(String pid) throws SQLException;

	PageBean findAllByPushDown(String currPageStr) throws SQLException;

	void update(Product product)throws SQLException;



}
