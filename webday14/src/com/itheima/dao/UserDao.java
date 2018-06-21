package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.bean.User;
import com.itheima.utils.c3p0Util;

public class UserDao {

	public void registerUser(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql = "insert into user values (null,?,?,?,?,?,?)";
		String[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.gettelephone()};
		queryRunner.update(sql, params);	
	}

}
