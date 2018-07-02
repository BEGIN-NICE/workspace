package com.itheima.load.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.load.domain.User;
import com.itheima.utils.c3p0Util;

public class UserDao {

	public int add(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "insert into user values (null,?,?,?)";
		int update = queryRunner.update(sql, user.getUsername(),user.getPassword(),user.getPhotouuid());
		return update;
	}

	public User checkUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from user where username = ? and password = ? and photouuid = ?";
		User query = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword(),user.getPhotouuid());
		return query;
	}
	
	public User login(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User query = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		return query;
	}

}
