package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.utils.c3p0Util;

public class LoginDao {

	public User checkUsername(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from user where username = ?";
		User exsitUser = queryRunner.query(sql, new BeanHandler<User>(User.class),user.getUsername());
		return exsitUser;
	}
	
	public User checkUserpassword(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from user where password = ?";
		User exsitUser = queryRunner.query(sql, new BeanHandler<User>(User.class),user.getPassword());
		return exsitUser;
	}

}
