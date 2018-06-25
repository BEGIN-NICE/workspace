package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Word;
import com.itheima.utils.c3p0Util;

public class SearchDao {

	public List<Word> search(String info) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from word where info like ?";
		List<Word> list = queryRunner.query(sql, new BeanListHandler<Word>(Word.class),"%"+info+"%");
		return list;
	}

}
