package com.itheima.store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.store.dao.SearchDao;
import com.itheima.store.domain.Product;
import com.itheima.store.utils.c3p0Util;

public class SearchDaoImpl implements SearchDao {

	@Override
	public List<Product> findByPname(String search) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from product where pname like ? limit ?";
		List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),"%"+search+"%",12);
		return list;
	}

	@Override
	public Integer findCountByPname(String search) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select count(*) from product where pname like ?";
		Long l = (Long) queryRunner.query(sql, new ScalarHandler(),"%"+search+"%");
		return l.intValue();
	}

}
