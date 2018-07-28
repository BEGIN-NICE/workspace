package com.demo.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.itheima.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String username, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),username,password);
		return user;
	}

}
