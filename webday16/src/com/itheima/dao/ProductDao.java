package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;
import com.itheima.utils.c3p0Util;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pid in (?,?,?,?,?,?)";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class),"1","2","3","4","5","6");
		return list;
	}

}
