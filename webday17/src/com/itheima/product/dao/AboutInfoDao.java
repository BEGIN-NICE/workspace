package com.itheima.product.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.itheima.utils.c3p0Util;

public class AboutInfoDao {

	public List<String> aboutInfo(String info) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select pname from product where pname like ?";
		List<Object> list = queryRunner.query(sql, new ColumnListHandler("pname"),"%"+info+"%");
		ArrayList<String> array = new ArrayList<>();
		for (Object obj : list) {
			array.add((String)obj);
		}
		return array;
	}

}
