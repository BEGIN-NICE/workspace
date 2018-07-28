package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.domain.Product;

public interface ProductService {

	List<Product> findAll() throws SQLException;

}
