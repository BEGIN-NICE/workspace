package com.itheima.product.service;

import java.sql.SQLException;

import com.itheima.product.dao.ProductAddDao;
import com.itheima.product.domain.Product;

public class ProductAddService {

	public int addProduct(Product product) throws SQLException {
		ProductAddDao productAddDao = new ProductAddDao();
		return productAddDao.addProduct(product);
	}

}
