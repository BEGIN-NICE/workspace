package com.itheima.load.service;

import java.sql.SQLException;

import com.itheima.load.dao.UserDao;
import com.itheima.load.domain.User;

public class UserService {

	public int add(User user) throws SQLException {
		UserDao userDao = new UserDao();
		
		return userDao.add(user);
	}

	public User checkUser(User user) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.checkUser(user);
	}

	public User login(User user) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.login(user);
	}

}
