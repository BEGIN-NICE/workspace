package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

public class UserService {
	public User login(User user) {
		UserDao userDao = new UserDao();
		User login = null;
		try {
			login = userDao.login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
}
