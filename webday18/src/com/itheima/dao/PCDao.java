package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.City;
import com.itheima.domain.Province;
import com.itheima.utils.c3p0Util;

public class PCDao {

	public List<Province> findProvince() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from province";
		List<Province> list = queryRunner.query(sql, new BeanListHandler<Province>(Province.class));
		return list;
	}

	public List<City> findCityBypId(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from city where pid = ?";
		List<City> list = queryRunner.query(sql, new BeanListHandler<City>(City.class),pid);
		return list;
	}

}
