package com.demo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.dao.ProductDao;
import com.demo.domain.Product;
import com.itheima.utils.JDBCUtil;
import com.sun.rowset.JdbcRowSetResourceBundle;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from product";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
