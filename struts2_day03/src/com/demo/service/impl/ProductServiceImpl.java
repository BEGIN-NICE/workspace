package com.demo.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.dao.impl.ProductDaoImpl;
import com.demo.domain.Product;
import com.demo.service.ProductService;


public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDaoImpl();
		return productDao.findAll();
	}

}
