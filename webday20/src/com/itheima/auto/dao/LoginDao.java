package com.itheima.auto.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.auto.domain.User;
import com.itheima.utils.c3p0Util;

public class LoginDao {

	public User login(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User query = queryRunner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		return query;
	}

}
