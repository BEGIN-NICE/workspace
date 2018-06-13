package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.pojo.User;
import com.itheima.utils.c3p0Util;

public class UserDao {

	public User login(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
//		queryRunner.query("select * form user where username=? and password=?", beanHandler<User>(User.class),user.getUsername(),user.getPassword())
		User query = queryRunner.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		System.out.println(query);
		return query;
	}
}
