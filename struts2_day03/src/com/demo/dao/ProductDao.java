package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.domain.Product;

public interface ProductDao {

	List<Product> findAll() throws SQLException;

}
