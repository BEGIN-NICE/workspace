package com.itheima.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.store.domain.Product;

public interface SearchDao {

	List<Product> findByPname(String search) throws SQLException;

	Integer findCountByPname(String search)throws SQLException;
	
}
